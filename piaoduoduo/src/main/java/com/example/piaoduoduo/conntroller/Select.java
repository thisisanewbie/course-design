package com.example.piaoduoduo.conntroller;
import com.example.piaoduoduo.FreshT;
import com.example.piaoduoduo.mapper.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/fresh/{key}")
public class Select {
    /*
    * websocket由于实现一次HTTP握手就NEW一个对象，
    * 无法使用@Autowired注入，如下方法实测可以
    * 切记变量要加static
    * */
    public static SeatDao seatDao;
    @Autowired
    public void setSeatDao(SeatDao seatDao) {
        Select.seatDao=seatDao;
    }
    private static CopyOnWriteArraySet<Select> socket = new CopyOnWriteArraySet<>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("key") String key) throws InterruptedException {

        this.session = session;
        socket.add(this);
        try {
            sendMessage("连接成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FreshT freshT=new FreshT(Integer.parseInt(key));
        Thread thread=new Thread(freshT);
        thread.start();System.out.println("新开线程");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        socket.remove(this);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     *            客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String key) throws IOException, InterruptedException {
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

    /**
     * 服务端发送消息给客户端
     */
    public void sendMessage(String message) throws IOException {
            this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发
     */
    public static void sendInfo(String message){
        if (CollectionUtils.isEmpty(socket)){
            return;
        }
        if (message != null && message.isEmpty()) {
            return;
        }

        for (Select sendObjectMessage : socket) {
            try {
                sendObjectMessage.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
