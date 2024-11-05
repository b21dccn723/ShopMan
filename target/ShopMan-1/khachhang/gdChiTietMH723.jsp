<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ShopMan.dao.MatHangDAO723"%>
<%@page import="com.ShopMan.model.MatHang723"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Mặt Hàng</title>
    <link rel="stylesheet" type="text/css" href="../css/khachhang/gdChiTietMH723.css">
</head>
<body>
    <div class="container">
        <h2>Chi Tiết Mặt Hàng</h2>

        <%
            String idStr = request.getParameter("id");
            if (idStr != null && !idStr.trim().isEmpty()) {
                int id = Integer.parseInt(idStr);
                MatHangDAO723 matHangDAO = new MatHangDAO723();
                MatHang723 matHang = matHangDAO.LayThongTinMH(id);

                if (matHang != null) {
        %>
                    <p><strong>Tên:</strong> <%= matHang.getTen() %></p>
                    <p><strong>Đơn Giá:</strong> <%= matHang.getDonGia() %> VND</p>
                    <p><strong>Số Lượng Còn:</strong> <%= matHang.getSoLuongCon() %></p>
                    <p><strong>Mô Tả:</strong> <%= matHang.getMoTa() %></p>
                    <p><strong>Xuất Xứ:</strong> <%= matHang.getXuatXu() %></p>
        <%
                } else {
        %>
                    <p class="error">Mặt hàng không tồn tại.</p>
        <%
                }
            } else {
        %>
                <p class="error">ID mặt hàng không hợp lệ.</p>
        <%
            }
        %>

        <div class="button">
            <form action="gdTimKiemMH723.jsp" method="get">
                <input type="submit" value="Trở về trang tìm kiếm">
            </form>
        </div>
    </div>
</body>
</html>
