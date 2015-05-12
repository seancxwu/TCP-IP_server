/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpip.server;

/**
 *
 * @author krille0x7c2
 */
public class RawData {

    private byte xl;
    private byte yl;
    private byte zl;
    private byte xh;
    private byte yh;
    private byte zh;
    private int low;
    private int middle;
    private int high;
    private int global_select;

    /**
     * @return the xl
     */
    public byte getXl() {
        return xl;
    }

    /**
     * @param xl the xl to set
     */
    public void setXl(byte xl) {
        this.xl = xl;
    }

    /**
     * @return the yl
     */
    public byte getYl() {
        return yl;
    }

    /**
     * @param yl the yl to set
     */
    public void setYl(byte yl) {
        this.yl = yl;
    }

    /**
     * @return the zl
     */
    public byte getZl() {
        return zl;
    }

    /**
     * @param zl the zl to set
     */
    public void setZl(byte zl) {
        this.zl = zl;
    }

    /**
     * @return the xh
     */
    public byte getXh() {
        return xh;
    }

    /**
     * @param xh the xh to set
     */
    public void setXh(byte xh) {
        this.xh = xh;
    }

    /**
     * @return the yh
     */
    public byte getYh() {
        return yh;
    }

    /**
     * @param yh the yh to set
     */
    public void setYh(byte yh) {
        this.yh = yh;
    }

    /**
     * @return the zh
     */
    public byte getZh() {
        return zh;
    }

    /**
     * @param zh the zh to set
     */
    public void setZh(byte zh) {
        this.zh = zh;
    }

    /**
     * @return the low
     */
    public int getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(int low) {
        this.low = low;
    }

    /**
     * @return the middle
     */
    public int getMiddle() {
        return middle;
    }

    /**
     * @param middle the middle to set
     */
    public void setMiddle(int middle) {
        this.middle = middle;
    }

    /**
     * @return the high
     */
    public int getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(int high) {
        this.high = high;
    }

    public int getBar() {
        return (getHigh() * 65536 + getMiddle() *256 + getLow());
    }

    public int getTemp() {

        return (getHigh() * 256) + getLow();
    }

    /**
     * @return the x16
     */
    public int getX16() {
        return ((xh *256) + xl);
    }

    /**
     * @return the y16
     */
    public int getY16() {
        return  ((yh *256) + yl);
    }

    /**
     * @return the z16
     */
    public int getZ16() {
        return  ((zh *256) + zl);
    }

    /**
     * @return the global_select
     */
    public int getGlobal_select() {
        return global_select;
    }

    /**
     * @param global_select the global_select to set
     */
    public void setGlobal_select(int global_select) {
        this.global_select = global_select;
    }

}
