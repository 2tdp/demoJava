/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieuhoamain;

/**
 *
 * @author kl100
 */
public class DHSamSung extends DieuHoa {

    private int thangBaoHanh;

    public int getThangBaoHanh() {
        return thangBaoHanh;
    }

    @Override
    public void nhapTT() {
        super.nhapTT();
        System.out.println("Nhap thang bao hanh: ");
        thangBaoHanh = sc.nextInt();
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void hienThiTT() {
        super.hienThiTT();
        System.out.println("Thang bao hanh: " + thangBaoHanh + " thang" + "\nMuc tieu thu dien nang: " + tieuThuDienNang());
    }

}
