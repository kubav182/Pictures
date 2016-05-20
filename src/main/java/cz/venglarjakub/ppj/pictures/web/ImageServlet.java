package cz.venglarjakub.ppj.pictures.web;

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

    private final String IMAGE_DIR = "c:/tmp";
    private final String DEFAULT_IMAGE = "not-found.png";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getPathInfo().substring(1);
        File file = new File(IMAGE_DIR, filename);
        if (!file.exists()) {
            file = new File(IMAGE_DIR, DEFAULT_IMAGE);
        }
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=/ + filename + /");
        Files.copy(file.toPath(), response.getOutputStream());
    }

}

