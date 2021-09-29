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
public class DHDaikin extends DieuHoa {

    private boolean isInventer;

    public boolean isIsInventer() {
        return isInventer;
    }

    @Override
    public float tieuThuDienNang() {
        float tieuThuDienNang;
        if (isInventer) {
            tieuThuDienNang = tieuThuDienNang();
        } else {
            tieuThuDienNang = tieuThuDienNang() * 100 / TIET_KIEM_DIEN;
        }
        return tieuThuDienNang;
    }

    @Override
    public void nhapTT() {
        super.nhapTT();
        String choose;
        sc.nextLine();
        System.out.println("Inventer(Y/N): ");
        do {
            choose = sc.nextLine().toUpperCase();
            switch (choose) {
                case "Y":
                    isInventer = true;
                    break;
                case "N":
                    isInventer = false;
                    break;
                default:
                    System.out.println("Nhap sai. Hay nhap lai");
                    break;
            }
        } while (!choose.equalsIgnoreCase("Y") || !choose.equalsIgnoreCase("N"));
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void hienThiTT() {
        super.hienThiTT();
        System.out.println("Muc tieu thu dien nang: " + tieuThuDienNang() + "\nInvener: " + (isInventer ? "Yes" : "No"));
    }

}
