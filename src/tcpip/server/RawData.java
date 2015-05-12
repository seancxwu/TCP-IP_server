package tcpip.server;

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

    public byte getXl() {
        return xl;
    }

    public void setXl(byte xl) {
        this.xl = xl;
    }

    public byte getYl() {
        return yl;
    }

    public void setYl(byte yl) {
        this.yl = yl;
    }


    public byte getZl() {
        return zl;
    }

    public void setZl(byte zl) {
        this.zl = zl;
    }

    public byte getXh() {
        return xh;
    }

    public void setXh(byte xh) {
        this.xh = xh;
    }

    public byte getYh() {
        return yh;
    }

    public void setYh(byte yh) {
        this.yh = yh;
    }

    public byte getZh() {
        return zh;
    }

    public void setZh(byte zh) {
        this.zh = zh;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getBar() {
        return (getHigh() * 65536 + getMiddle() *256 + getLow());
    }

    public int getTemp() {

        return (getHigh() * 256) + getLow();
    }

    public int getX16() {
        return ((xh *256) + xl);
    }

    public int getY16() {
        return  ((yh *256) + yl);
    }

    public int getZ16() {
        return  ((zh *256) + zl);
    }
    
    public int getGlobal_select() {
        return global_select;
    }

    public void setGlobal_select(int global_select) {
        this.global_select = global_select;
    }

}
