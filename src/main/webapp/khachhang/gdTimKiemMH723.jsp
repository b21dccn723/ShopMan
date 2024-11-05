<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.ShopMan.dao.MatHangDAO723"%>
<%@page import="com.ShopMan.model.MatHang723"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tìm Kiếm Mặt Hàng</title>
    <link rel="stylesheet" type="text/css" href="../css/khachhang/gdTimKiemMH723.css">
</head>
<body>
    <div class="container">
        <h2>Tìm Kiếm Mặt Hàng</h2>
        <form action="gdTimKiemMH723.jsp" method="get">
            <label for="keyword">Tên mặt hàng:</label>
            <input type="text" id="keyword" name="keyword">
            <input type="submit" value="Tìm Kiếm">
        </form>

        <h3>Kết Quả Tìm Kiếm</h3>
        <table>
            <thead>
                <tr>
                    <th>Tên</th>
                    <th>Đơn Giá</th>
                    <th>Số Lượng Còn</th>
                    <th>Xuất Xứ</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    MatHangDAO723 matHangDAO = new MatHangDAO723();
                    List<MatHang723> danhSachMatHang = null;

                    String keyword = request.getParameter("keyword");
                    if (keyword != null) {
                        if (keyword.trim().isEmpty()) {
                            danhSachMatHang = matHangDAO.LayTatCaMH();
                        } else {
                            danhSachMatHang = matHangDAO.TimKiemMH(keyword);
                        }
                    }

                    if (danhSachMatHang != null && !danhSachMatHang.isEmpty()) {
                        for (MatHang723 matHang : danhSachMatHang) {
                %>
                            <tr>
                                <td><%= matHang.getTen() %></td>
                                <td><%= matHang.getDonGia() %></td>
                                <td><%= matHang.getSoLuongCon() %></td>
                                <td><%= matHang.getXuatXu() %></td>
                                <td>
                                    <form action="gdChiTietMH723.jsp" method="get">
                                        <input type="hidden" name="id" value="<%= matHang.getId() %>">
                                        <input type="submit" value="Xem">
                                    </form>
                                </td>
                            </tr>
                <%
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="5">Không tìm thấy mặt hàng nào.</td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
