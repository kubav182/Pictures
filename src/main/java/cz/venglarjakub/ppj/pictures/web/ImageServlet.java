package cz.venglarjakub.ppj.pictures.web;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Jakub Venglar <jakub.venglar at aspectworks.com>
 */
@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    @Value("${cz.venglarjakub.ppj.pictures.web.image-dir}")
    private String imageDir;
    @Value("${cz.venglarjakub.ppj.pictures.web.default-image}")
    private String defaultImage;
    @Value("${server.contextPath}")
    private String path;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getPathInfo().substring(1);
        File file = new File(imageDir, filename);
        if (!file.exists()) {
            file = new File(imageDir, defaultImage);
        }
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=/ + filename + /");
        Files.copy(file.toPath(), response.getOutputStream());
    }

}

