package net.lingala.zip4j.model;

public class DataDescriptor extends ZipHeader {
    private long compressedSize;
    private long crc;
    private long uncompressedSize;

    public long getCrc() {
        return this.crc;
    }

    public void setCrc(long crc2) {
        this.crc = crc2;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public void setCompressedSize(long compressedSize2) {
        this.compressedSize = compressedSize2;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void setUncompressedSize(long uncompressedSize2) {
        this.uncompressedSize = uncompressedSize2;
    }
}
