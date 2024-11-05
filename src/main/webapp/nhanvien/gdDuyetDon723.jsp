<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.ShopMan.dao.DonHangDAO723"%>
<%@page import="com.ShopMan.model.DonHang723"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Duyệt Đơn Hàng</title>
    <link rel="stylesheet" type="text/css" href="../css/nhanvien/gdDuyetDon723.css">
</head>
<body>
    <div class="container">
        <h2>Duyệt Đơn Hàng</h2>
        <table>
            <thead>
                <tr>
                    <th>Mã Đơn Hàng</th>
                    <th>Trạng Thái</th>
                    <th>Tổng Tiền</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DonHangDAO723 donHangDAO = new DonHangDAO723();
                    List<DonHang723> danhSachDonHang = donHangDAO.getDonHang();
                    for (DonHang723 donHang : danhSachDonHang) {
                %>
                <tr>
                    <td><%= donHang.getMaDonHang() %></td>
                    <td><%= donHang.getTrangThaiDonHang() %></td>
                    <td><%= donHang.getTongTien() %></td>
                    <td>
                        <form action="gdCapNhatDon723.jsp" method="get">
                            <input type="hidden" name="id" value="<%= donHang.getId() %>">
                            <input type="submit" value="Duyệt">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
