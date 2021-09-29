/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieuhoamain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author kl100
 */
public class DieuHoaMain {

    Scanner sc;
    ArrayList<DieuHoa> lstDH;
    private int dem = 0, max = 0;
    private float min = 999999f;

    public static void main(String[] args) {
        DieuHoaMain dh = new DieuHoaMain();

        dh.sc = new Scanner(System.in);
        dh.lstDH = new ArrayList();

        int a;
        do {
            dh.menu();

            System.out.println("Nhap lua chon: ");
            a = dh.sc.nextInt();
            if (a < 1 || a > 8) {
                System.out.println("Chon sai. Hay chon lai!");
            }

            switch (a) {
                case 1:
                    dh.input();
                    break;
                case 2:
                    dh.display();
                    break;
                case 3:
                    dh.searchByName();
                    break;
                case 4:
                    dh.consumptionMin();
                    break;
                case 5:
                    dh.warrantyMax();
                    break;
                case 6:
                    dh.isInventer();
                    break;
                case 7:
                    dh.sortByName();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (a > 0 && a < 9);
    }

    public void menu() {
        System.out.println("1. Nhập thông tin\n"
                + "2. Hiển thị thông tin\n"
                + "3. Tìm sản phẩm theo tên\n"
                + "4. Hiển thị sản phẩm có mức tiêu thụ điện năng thấp nhất\n"
                + "5. Hiển thị sản phẩm có tháng bảo hành nhiều nhất\n"
                + "6. Hiển thị sản phẩm có hỗ trợ INVENTER\n"
                + "7. Hiển thị sản phẩm sau khi sắp xếp theo tên\n"
                + "8. Thoát");
    }

    public void input() {
        System.out.println("Chon loai dieu hoa: "
                + "\n1. Dieu hoa SamSung(1)"
                + "\n2. Dieu hoa Daikin(2)");
        int choose = sc.nextInt();
        System.out.println("----------------------------------------------------");

        switch (choose) {
            case 1:
                DHSamSung ss = new DHSamSung();
                ss.nhapTT();
                lstDH.add(ss);
                break;
            case 2:
                DHDaikin dk = new DHDaikin();
                dk.nhapTT();
                lstDH.add(dk);
                break;
            default:
                System.out.println("Nhap sai. Hay nhap lai");
                break;
        }
    }

    public void display() {
        System.out.println("Danh sach dieu hoa: ");
        for (int i = 0; i < lstDH.size(); i++) {
            System.out.println("Thong tin dieu hoa thu " + (i + 1) + ": ");
            lstDH.get(i).hienThiTT();
        }
    }

    public void searchByName() {
        System.out.println("Nhap ten dieu hoa muon tim: ");
        String search = sc.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.println("Danh sach dieu hoa can tim: ");
        for (DieuHoa dh : lstDH) {
            if (dh.getNhanHieu().equalsIgnoreCase(search)) {
                dh.hienThiTT();
                dem += 1;
            }
        }
        if (dem == 0) {
            System.out.println("Khong co dieu hoa can tim!");
        }
    }

    public void consumptionMin() {
        for (DieuHoa dh : lstDH) {
            if (dh.tieuThuDienNang() < min) {
                min = dh.tieuThuDienNang();
            }
        }
        System.out.println("Danh sach dieu hoa co muc tieu thu dien nang thap nhat");
        for (DieuHoa dh : lstDH) {
            if (dh.tieuThuDienNang() == min) {
                dh.hienThiTT();
            }
        }
    }

    public void warrantyMax() {
        for (DieuHoa dh : lstDH) {
            if (dh instanceof DHSamSung) {
                DHSamSung ss = (DHSamSung) dh;
                if (ss.getThangBaoHanh() > max) {
                    max = ss.getThangBaoHanh();
                }
            }
        }
        for (DieuHoa dh : lstDH) {
            if (dh instanceof DHSamSung) {
                DHSamSung ss = (DHSamSung) dh;
                if (ss.getThangBaoHanh() == max) {
                    ss.hienThiTT();
                }
            }
        }
    }

    public void isInventer() {
        System.out.println("Nhung san pham co hoa tro INVENTER: ");
        for (DieuHoa dh : lstDH) {
            if (dh instanceof DHDaikin) {
                DHDaikin dk = (DHDaikin) dh;
                if (dk.isIsInventer()) {
                    dk.hienThiTT();
                }
            }
        }
    }

    public void sortByName() {
        System.out.println("Danh sach san pham sau khi sap xep(theo ten): ");
        Collections.sort(lstDH, (DieuHoa dh1, DieuHoa dh2) -> dh1.getNhanHieu().compareToIgnoreCase(dh2.getNhanHieu()));
        for (DieuHoa dh : lstDH) {
            dh.hienThiTT();
        }
    }
}
