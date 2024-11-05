<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.ShopMan.dao.DonHangDAO723"%>
<%@page import="com.ShopMan.dao.NVGiaoHangDAO723"%>
<%@page import="com.ShopMan.model.DonHang723"%>
<%@page import="com.ShopMan.model.NVGiaoHang723"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Cập Nhật Đơn Hàng</title>
        <link rel="stylesheet" type="text/css" href="../css/nhanvien/gdCapNhatDon723.css">
        <script>
            function showSuccessMessage(message) {
                alert(message);
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h2>Cập Nhật Đơn Hàng</h2>
            <%
                if ("POST".equalsIgnoreCase(request.getMethod())) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    int tblNVGiaoHangid = Integer.parseInt(request.getParameter("tblNVGiaoHangid"));
                    String trangThaiDonHang = request.getParameter("trangThaiDonHang");

                    DonHang723 donHang = new DonHang723();
                    donHang.setId(id);
                    donHang.setTblNVGiaoHangid(tblNVGiaoHangid);
                    donHang.setTrangThaiDonHang(trangThaiDonHang);

                    DonHangDAO723 donHangDAO = new DonHangDAO723();
                    boolean success = donHangDAO.luuDonHang(donHang);
                    if (success) {
                        request.setAttribute("successMessage", "Đơn hàng đã được cập nhật thành công.");
                    } else {
                        request.setAttribute("errorMessage", "Cập nhật đơn hàng thất bại.");
                    }
                }

                int id = Integer.parseInt(request.getParameter("id"));
                DonHangDAO723 donHangDAO = new DonHangDAO723();
                DonHang723 donHang = donHangDAO.getChiTietDon(id);
                if (donHang != null) {
            %>
            <form action="gdCapNhatDon723.jsp" method="post" class="form-update">
                <div class="form-group">
                    <label for="maDonHang">Mã Đơn Hàng:</label>
                    <input type="text" id="maDonHang" name="maDonHang" value="<%= donHang.getMaDonHang()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="trangThaiDonHang">Trạng Thái Đơn Hàng:</label>
                    <select id="trangThaiDonHang" name="trangThaiDonHang">
                        <option value="Chưa duyệt" <%= donHang.getTrangThaiDonHang().equals("Chưa duyệt") ? "selected" : ""%>>Chưa duyệt</option>
                        <option value="Đã duyệt" <%= donHang.getTrangThaiDonHang().equals("Đã duyệt") ? "selected" : ""%>>Đã duyệt</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="tblNVGiaoHangid">Nhân Viên Giao Hàng:</label>
                    <span id="nvghTen"><%= donHang.getTblNVGiaoHangid() != 0 ? new NVGiaoHangDAO723().layChiTietNVGH(donHang.getTblNVGiaoHangid()).getTen() : "Chưa chọn"%></span>
                    <input type="hidden" id="tblNVGiaoHangid" name="tblNVGiaoHangid" value="<%= donHang.getTblNVGiaoHangid()%>">
                    <br>
                    <button type="button" class="btn btn-primary" onclick="window.open('gdChonNVGH723.jsp?donHangId=<%= donHang.getId()%>', '_blank')">Chọn NVGH</button>
                </div>
                <input type="hidden" name="id" value="<%= donHang.getId()%>">
                <div class="form-group=">
                    <button type="submit" class="btn-submit">Lưu</button>
                </div>
            </form>
            <%
                String successMessage = (String) request.getAttribute("successMessage");
                if (successMessage != null) {
            %>
            <script>
                showSuccessMessage("<%= successMessage %>");
            </script>
            <%
                }
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
            <p class="error-message"><%= errorMessage %></p>
            <%
                }
            %>
            <div class="buttons">
                <button onclick="window.history.back();" class="btn btn-secondary">Quay lại</button>
                <button onclick="location.href = 'gdInHoaDon723.jsp?id=<%= donHang.getId()%>'" class="btn btn-print">In Hóa Đơn</button>
            </div>
            <%
                } else {
            %>
            <p class="error-message">Không tìm thấy đơn hàng.</p>
            <%
                }
            %>
        </div>
    </body>
</html>
