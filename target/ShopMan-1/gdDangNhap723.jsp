<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" type="text/css" href="../css/gdDangNhap723.css">
</head>
<body>
    <div class="login-container">
        <h2>Đăng Nhập</h2>
        <form action="login" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" required>
            <br>
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <input type="submit" value="Đăng Nhập">
        </form>

        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                com.ShopMan.dao.ThanhVienDAO723 thanhVienDAO = new com.ShopMan.dao.ThanhVienDAO723();
                com.ShopMan.model.ThanhVien723 user = thanhVienDAO.login(username, password);

                if (user != null) {
                    session.setAttribute("user", user);
                    if ("Nhân Viên".equals(user.getVaitro())) {
                        response.sendRedirect("nhanvien/gdChinhNV723.jsp");
                    } else if ("Khách Hàng".equals(user.getVaitro())) {
                        response.sendRedirect("khachhang/gdChinhKH723.jsp");
                    }
                } else {
                    out.println("<p class='error'>Sai tên đăng nhập hoặc mật khẩu!</p>");
                }
            }
        %>
    </div>
</body>
</html>
