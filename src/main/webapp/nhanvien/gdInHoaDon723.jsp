<%@page import="com.ShopMan.dao.KhachHangDAO723"%>
<%@page import="com.ShopMan.dao.NVGiaoHangDAO723"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ShopMan.dao.DonHangDAO723"%>
<%@page import="com.ShopMan.model.DonHang723"%>
<%@page import="com.ShopMan.model.GioHangItem723"%>
<%@page import="com.ShopMan.model.NVGiaoHang723"%>
<%@page import="com.ShopMan.model.KhachHang723"%>
<%@page import="com.ShopMan.model.HoaDon723"%>
<%@page import="com.ShopMan.dao.HoaDonDAO723"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>In Hóa Đơn</title>
    <link rel="stylesheet" type="text/css" href="../css/nhanvien/gdInHoaDon723.css">
    <script>
        function printInvoice() {
            window.print();
        }
    </script>
</head>
<body>
    <div class="invoice-container">
        <div class="invoice-header">
            <h1>Hóa Đơn</h1>
        </div>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            DonHangDAO723 donHangDAO = new DonHangDAO723();
            DonHang723 donHang = donHangDAO.getChiTietDon(id);
            NVGiaoHang723 nvGiaoHang = new NVGiaoHangDAO723().layChiTietNVGH(donHang.getTblNVGiaoHangid());
            KhachHang723 khachHang = new KhachHangDAO723().layThongTinKhachHang(donHang.getTblKhachHangid());

            // Tạo mã hóa đơn
            String maHoaDon = "HD" + donHang.getMaDonHang(); // Hoặc tạo mã theo cách bạn muốn
            HoaDon723 hoaDon = new HoaDon723();
            HoaDonDAO723 hoaDonDAO = new HoaDonDAO723();

            if (donHang != null) {
                // Lưu hóa đơn vào cơ sở dữ liệu
                hoaDon = new HoaDon723(maHoaDon, donHang.getId(), new Date(), donHang.getTongTien());
                if (hoaDonDAO.luuHoaDon(hoaDon)) {
                    // Hóa đơn đã lưu thành công
        %>
        <div class="invoice-details">
            <table>
                <tr>
                    <th>Mã Đơn Hàng</th>
                    <td><%= donHang.getMaDonHang() %></td>
                </tr>
                <tr>
                    <th>Ngày Tạo Đơn</th>
                    <td><%= new SimpleDateFormat("dd/MM/yyyy").format(donHang.getNgayTao()) %></td>
                </tr>
                <tr>
                    <th>Nhân Viên Giao Hàng</th>
                    <td><%= nvGiaoHang.getTen() %></td>
                </tr>
                <tr>
                    <th>Khách Hàng</th>
                    <td><%= khachHang.getTen() %></td>
                </tr>
            </table>
            
            <!-- Display Items in Gio Hang -->
            <h3>Mặt Hàng Đã Mua:</h3>
            <table>
                <thead>
                    <tr>
                        <th>Tên Mặt Hàng</th>
                        <th>Số Lượng</th>
                        <th>Giá Bán</th>
                        <th>Thành Tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<GioHangItem723> danhSachItems = donHangDAO.getItemsInGioHang(donHang.getTblGioHangid());
                        for (GioHangItem723 item : danhSachItems) {
                    %>
                    <tr>
                        <td><%= item.getTenMatHang() %></td>
                        <td><%= item.getSoLuong() %></td>
                        <td><%= item.getGiaBan() %></td>
                        <td><%= item.getSoLuong() * item.getGiaBan() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <div class="total-amount">
                <h3>Tổng Tiền:</h3>
                <p><%= donHang.getTongTien() %></p>
            </div>
        </div>
        <div class="invoice-footer">
            <button class="print-button" onclick="printInvoice()">Lưu và In Hóa Đơn</button>
        </div>
        <%
                } else {
                    // Xảy ra lỗi khi lưu hóa đơn
                    out.println("<p>Lỗi khi lưu hóa đơn!</p>");
                }
            } else {
        %>
        <p>Không tìm thấy đơn hàng.</p>
        <%
            }
        %>
    </div>
</body>
</html>
