package net.lingala.zip4j.model;

import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class ZipParameters {
    private AesKeyStrength aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256;
    private AesVersion aesVersion = AesVersion.TWO;
    private CompressionLevel compressionLevel = CompressionLevel.NORMAL;
    private CompressionMethod compressionMethod = CompressionMethod.DEFLATE;
    private String defaultFolderPath;
    private boolean encryptFiles = false;
    private EncryptionMethod encryptionMethod = EncryptionMethod.NONE;
    private long entryCRC;
    private long entrySize = -1;
    private String fileComment;
    private String fileNameInZip;
    private boolean includeRootFolder = true;
    private long lastModifiedFileTime = System.currentTimeMillis();
    private boolean overrideExistingFilesInZip = true;
    private boolean readHiddenFiles = true;
    private boolean readHiddenFolders = true;
    private String rootFolderNameInZip;
    private SymbolicLinkAction symbolicLinkAction = SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY;
    private boolean writeExtendedLocalFileHeader = true;

    public enum SymbolicLinkAction {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public ZipParameters() {
    }

    public ZipParameters(ZipParameters zipParameters) {
        this.compressionMethod = zipParameters.getCompressionMethod();
        this.compressionLevel = zipParameters.getCompressionLevel();
        this.encryptFiles = zipParameters.isEncryptFiles();
        this.encryptionMethod = zipParameters.getEncryptionMethod();
        this.readHiddenFiles = zipParameters.isReadHiddenFiles();
        this.readHiddenFolders = zipParameters.isReadHiddenFolders();
        this.aesKeyStrength = zipParameters.getAesKeyStrength();
        this.aesVersion = zipParameters.getAesVersion();
        this.includeRootFolder = zipParameters.isIncludeRootFolder();
        this.entryCRC = zipParameters.getEntryCRC();
        this.defaultFolderPath = zipParameters.getDefaultFolderPath();
        this.fileNameInZip = zipParameters.getFileNameInZip();
        this.lastModifiedFileTime = zipParameters.getLastModifiedFileTime();
        this.entrySize = zipParameters.getEntrySize();
        this.writeExtendedLocalFileHeader = zipParameters.isWriteExtendedLocalFileHeader();
        this.overrideExistingFilesInZip = zipParameters.isOverrideExistingFilesInZip();
        this.rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
        this.fileComment = zipParameters.getFileComment();
        this.symbolicLinkAction = zipParameters.getSymbolicLinkAction();
    }

    public CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod2) {
        this.compressionMethod = compressionMethod2;
    }

    public boolean isEncryptFiles() {
        return this.encryptFiles;
    }

    public void setEncryptFiles(boolean encryptFiles2) {
        this.encryptFiles = encryptFiles2;
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public void setEncryptionMethod(EncryptionMethod encryptionMethod2) {
        this.encryptionMethod = encryptionMethod2;
    }

    public CompressionLevel getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(CompressionLevel compressionLevel2) {
        this.compressionLevel = compressionLevel2;
    }

    public boolean isReadHiddenFiles() {
        return this.readHiddenFiles;
    }

    public void setReadHiddenFiles(boolean readHiddenFiles2) {
        this.readHiddenFiles = readHiddenFiles2;
    }

    public boolean isReadHiddenFolders() {
        return this.readHiddenFolders;
    }

    public void setReadHiddenFolders(boolean readHiddenFolders2) {
        this.readHiddenFolders = readHiddenFolders2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public AesKeyStrength getAesKeyStrength() {
        return this.aesKeyStrength;
    }

    public void setAesKeyStrength(AesKeyStrength aesKeyStrength2) {
        this.aesKeyStrength = aesKeyStrength2;
    }

    public AesVersion getAesVersion() {
        return this.aesVersion;
    }

    public void setAesVersion(AesVersion aesVersion2) {
        this.aesVersion = aesVersion2;
    }

    public boolean isIncludeRootFolder() {
        return this.includeRootFolder;
    }

    public void setIncludeRootFolder(boolean includeRootFolder2) {
        this.includeRootFolder = includeRootFolder2;
    }

    public long getEntryCRC() {
        return this.entryCRC;
    }

    public void setEntryCRC(long entryCRC2) {
        this.entryCRC = entryCRC2;
    }

    public String getDefaultFolderPath() {
        return this.defaultFolderPath;
    }

    public void setDefaultFolderPath(String defaultFolderPath2) {
        this.defaultFolderPath = defaultFolderPath2;
    }

    public String getFileNameInZip() {
        return this.fileNameInZip;
    }

    public void setFileNameInZip(String fileNameInZip2) {
        this.fileNameInZip = fileNameInZip2;
    }

    public long getLastModifiedFileTime() {
        return this.lastModifiedFileTime;
    }

    public void setLastModifiedFileTime(long lastModifiedFileTime2) {
        if (lastModifiedFileTime2 > 0) {
            this.lastModifiedFileTime = lastModifiedFileTime2;
        }
    }

    public long getEntrySize() {
        return this.entrySize;
    }

    public void setEntrySize(long entrySize2) {
        this.entrySize = entrySize2;
    }

    public boolean isWriteExtendedLocalFileHeader() {
        return this.writeExtendedLocalFileHeader;
    }

    public void setWriteExtendedLocalFileHeader(boolean writeExtendedLocalFileHeader2) {
        this.writeExtendedLocalFileHeader = writeExtendedLocalFileHeader2;
    }

    public boolean isOverrideExistingFilesInZip() {
        return this.overrideExistingFilesInZip;
    }

    public void setOverrideExistingFilesInZip(boolean overrideExistingFilesInZip2) {
        this.overrideExistingFilesInZip = overrideExistingFilesInZip2;
    }

    public String getRootFolderNameInZip() {
        return this.rootFolderNameInZip;
    }

    public void setRootFolderNameInZip(String rootFolderNameInZip2) {
        this.rootFolderNameInZip = rootFolderNameInZip2;
    }

    public String getFileComment() {
        return this.fileComment;
    }

    public void setFileComment(String fileComment2) {
        this.fileComment = fileComment2;
    }

    public SymbolicLinkAction getSymbolicLinkAction() {
        return this.symbolicLinkAction;
    }

    public void setSymbolicLinkAction(SymbolicLinkAction symbolicLinkAction2) {
        this.symbolicLinkAction = symbolicLinkAction2;
    }
}
