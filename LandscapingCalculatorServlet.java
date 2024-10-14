import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class LandscapingCalculatorServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Input Parameters
        String address = request.getParameter("address");
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        String grassType = request.getParameter("grass");
        int numberOfTrees = Integer.parseInt(request.getParameter("trees"));

        // Base labour charge
        double totalPrice = 1000;

        // Calculate surface area
        double area = length * width;

        // Additional charge if area is over 5000 square feet
        if (area > 5000) {
            totalPrice += 500;
        }

        // Cost per square foot based on grass type
        double costPerSquareFoot;
        switch (grassType) {
            case "fescue":
                costPerSquareFoot = 0.05;
                break;
            case "bentgrass":
                costPerSquareFoot = 0.02;
                break;
            case "campus":
                costPerSquareFoot = 0.01;
                break;
            default:
                costPerSquareFoot = 0;
        }

        // Calculate grass cost
        totalPrice += area * costPerSquareFoot;

        // Calculate tree cost ($100 per tree)
        totalPrice += numberOfTrees * 100;

        // Output the result
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Landscaping Price for " + address + "</h2>");
        out.println("<p>Plot Area: " + area + " sq ft</p>");
        out.println("<p>Grass Type: " + grassType + "</p>");
        out.println("<p>Number of Trees: " + numberOfTrees + "</p>");
        out.println("<h3>Total Price: $" + totalPrice + "</h3>");
        out.println("</body></html>");
    }
}
