package org.chousik.weblab2.servlets;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.chousik.weblab2.bean.PointDao;
import org.chousik.weblab2.common.PointService;
import org.chousik.weblab2.common.ServiceInterface;
import org.chousik.weblab2.models.Point;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@WebServlet(value = "/area-servlet")
public class AreaCheckServlet extends HttpServlet {
    private ServiceInterface<Point> pointService;

    @Override
    public void init(){
        pointService = new PointService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            long startTime = System.nanoTime();

            Point point = new Point(Double.parseDouble((req.getParameter("x"))),
                    Double.parseDouble(req.getParameter("y")),
                    Double.parseDouble(req.getParameter("r")));
            if (!pointService.valid(point)){
                ControllerServlet.sendError(resp, "Invalid point", HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            PointDao bean = (PointDao) req.getSession().getAttribute("bean");
            if (bean == null){
                bean = new PointDao();
            }
            pointService.check(point);
            point.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            point.setExecutionTime(System.nanoTime() - startTime);
            bean.addPoint(point);
            req.getSession().setAttribute("bean", bean);

            Gson gson = new Gson();
            var ans = gson.toJson(point);

            resp.setContentType("application/json");
            resp.getWriter().write(ans);
            resp.getWriter().flush();
        }catch (NumberFormatException e){
            ControllerServlet.sendError(resp, e.toString(), HttpServletResponse.SC_BAD_REQUEST);
        }
        catch (Exception e){
            ControllerServlet.sendError(resp, e.toString(), HttpServletResponse.SC_BAD_GATEWAY);
        }
    }
}
