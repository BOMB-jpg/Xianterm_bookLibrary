package listener;

import com.tree.book.biz.TypeBiz;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.tree.book.bean.*;

import java.util.List;

@WebListener
public class TypeServletContextListener implements ServletContextListener {
    @Override      //一个作为application应用的创建
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       // 获取当前所有数据库中的类型信息
        TypeBiz biz =new TypeBiz();
        List<Type> types=biz.getAll();
        //获取applicaton对象
       ServletContext application=servletContextEvent.getServletContext();
        //将信息放到application对象中
        application.setAttribute("types",types);


    }

    @Override        //作为application应用的销毁
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
