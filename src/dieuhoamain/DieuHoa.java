/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieuhoamain;

import java.util.Scanner;

/**
 *
 * @author kl100
 */
public class DieuHoa implements IDieuHoaNhietDo, IInventer {

    private String ma;
    private String nhanHieu;
    private String nhaSX;
    private int congSuat;
    private float gia;

    public DieuHoa() {
    }

    public DieuHoa(String ma, String nhanHieu, String nhaSX, int congSuat, float gia) {
        this.ma = ma;
        this.nhanHieu = nhanHieu;
        this.nhaSX = nhaSX;
        this.congSuat = congSuat;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void nhapTT() {
        System.out.println("Nhap ma: ");
        ma = sc.nextLine();
        System.out.println("Nhap nhan hieu(5 - 32 ky tu): ");
        do {
            nhanHieu = sc.nextLine();
            if (nhanHieu.length() < 5 || nhanHieu.length() > 32) {
                System.err.println("Nhap sai quy dinh. Hay nhap lai nhan hieu!");
            }
        } while (nhanHieu.length() < 5 || nhanHieu.length() > 32);
        System.out.println("Nhap ten nha san xuat(32 - 128 ky tu): ");
        do {
            nhaSX = sc.nextLine();
            if (nhaSX.length() < 32 || nhaSX.length() > 128) {
                System.err.println("Nhap sai quy dinh. Hay nhap lai ten nha san xuat!");
            }
        } while (nhaSX.length() < 32 || nhaSX.length() > 128);
        System.out.println("Nhap cong suat(kwh): ");
        do {
            congSuat = sc.nextInt();
            if (congSuat < 100) {
                System.err.println("Nhap sai. Hay nhap lai!");
            }
        } while (congSuat < 100);
        System.out.println("Nhap gia: ");
        do {
            gia = sc.nextFloat();
            if (gia < 0) {
                System.err.println("Nhap sai. Hay nhap lai!");
            }
        } while (gia < 0);
    }

    @Override
    public void hienThiTT() {
        System.out.println("Ma: " + ma + "\nNhan hieu: " + nhanHieu + "\nNha san xuat: " + nhaSX + "\nCong suat: " + congSuat
                + "\nGia: " + gia);
    }

    @Override
    public float tieuThuDienNang() {
        return (congSuat * TIET_KIEM_DIEN / 100);
    }
}
