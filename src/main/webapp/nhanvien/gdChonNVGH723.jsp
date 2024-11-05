<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.ShopMan.dao.NVGiaoHangDAO723"%>
<%@page import="com.ShopMan.model.NVGiaoHang723"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chọn Nhân Viên Giao Hàng</title>
    <link rel="stylesheet" type="text/css" href="../css/nhanvien/gdChonNVGH723.css">
    <script>
        function chonNVGH(id, ten) {
            window.opener.document.getElementById('tblNVGiaoHangid').value = id;
            window.opener.document.getElementById('nvghTen').innerText = ten;
            window.close();
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Chọn Nhân Viên Giao Hàng</h2>
        <form action="gdChonNVGH723.jsp" method="get">
            <label for="search">Tìm kiếm:</label>
            <input type="text" id="search" name="search" value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">
            <input type="submit" value="Tìm kiếm">
        </form>
        <table>
            <thead>
                <tr>
                    <th>Tên Nhân Viên</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <%
                    NVGiaoHangDAO723 nvGiaoHangDAO = new NVGiaoHangDAO723();
                    List<NVGiaoHang723> danhSachNVGiaoHang = nvGiaoHangDAO.layNVGiaoHang();
                    for (NVGiaoHang723 nvGiaoHang : danhSachNVGiaoHang) {
                        if (request.getParameter("search") == null || nvGiaoHang.getTen().toLowerCase().contains(request.getParameter("search").toLowerCase())) {
                %>
                <tr>
                    <td><%= nvGiaoHang.getTen() %></td>
                    <td><button type="button" onclick="chonNVGH(<%= nvGiaoHang.getTblNhanVienid() %>, '<%= nvGiaoHang.getTen() %>')">Chọn</button></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
