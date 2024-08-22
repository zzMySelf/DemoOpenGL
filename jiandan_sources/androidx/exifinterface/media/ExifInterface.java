package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.widget.AutoScrollHelper;
import androidx.media.AudioAttributesCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.dlife.ctaccountapi.x;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.apache.commons.lang3.CharUtils;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final short BYTE_ALIGN_II = 18761;
    public static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    public static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    public static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    public static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    public static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    public static final byte[] IDENTIFIER_EXIF_APP1;
    public static final byte[] IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(ASCII);
    public static final ExifTag[] IFD_EXIF_TAGS = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_OFFSET_TIME, 36880, 2), new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifTag(TAG_GAMMA, 42240, 5), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    public static final int IFD_FORMAT_BYTE = 1;
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final int IFD_FORMAT_DOUBLE = 12;
    public static final int IFD_FORMAT_IFD = 13;
    public static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int IFD_FORMAT_SBYTE = 6;
    public static final int IFD_FORMAT_SINGLE = 11;
    public static final int IFD_FORMAT_SLONG = 9;
    public static final int IFD_FORMAT_SRATIONAL = 10;
    public static final int IFD_FORMAT_SSHORT = 8;
    public static final int IFD_FORMAT_STRING = 2;
    public static final int IFD_FORMAT_ULONG = 4;
    public static final int IFD_FORMAT_UNDEFINED = 7;
    public static final int IFD_FORMAT_URATIONAL = 5;
    public static final int IFD_FORMAT_USHORT = 3;
    public static final ExifTag[] IFD_GPS_TAGS = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
    public static final ExifTag[] IFD_INTEROPERABILITY_TAGS = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
    public static final int IFD_OFFSET = 8;
    public static final ExifTag[] IFD_THUMBNAIL_TAGS = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, 3), new ExifTag(TAG_COMPRESSION, PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, AuthorityState.STATE_INIT_ING, 2), new ExifTag(TAG_STRIP_OFFSETS, AudioAttributesCompat.FLAG_ALL_PUBLIC, 3, 4), new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, BindVerifyActivity.F, 2), new ExifTag(TAG_DATETIME, BindVerifyActivity.G, 2), new ExifTag(TAG_ARTIST, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, PayBeanFactory.BEAN_ID_CHECK_PWD, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
    public static final ExifTag[] IFD_TIFF_TAGS = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, 3), new ExifTag(TAG_COMPRESSION, PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, AuthorityState.STATE_INIT_ING, 2), new ExifTag(TAG_STRIP_OFFSETS, AudioAttributesCompat.FLAG_ALL_PUBLIC, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, BindVerifyActivity.F, 2), new ExifTag(TAG_DATETIME, BindVerifyActivity.G, 2), new ExifTag(TAG_ARTIST, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, PayBeanFactory.BEAN_ID_CHECK_PWD, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
    public static final int IFD_TYPE_EXIF = 1;
    public static final int IFD_TYPE_GPS = 2;
    public static final int IFD_TYPE_INTEROPERABILITY = 3;
    public static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    public static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    public static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    public static final int IFD_TYPE_PEF = 9;
    public static final int IFD_TYPE_PREVIEW = 5;
    public static final int IFD_TYPE_PRIMARY = 0;
    public static final int IFD_TYPE_THUMBNAIL = 4;
    public static final int IMAGE_TYPE_ARW = 1;
    public static final int IMAGE_TYPE_CR2 = 2;
    public static final int IMAGE_TYPE_DNG = 3;
    public static final int IMAGE_TYPE_HEIF = 12;
    public static final int IMAGE_TYPE_JPEG = 4;
    public static final int IMAGE_TYPE_NEF = 5;
    public static final int IMAGE_TYPE_NRW = 6;
    public static final int IMAGE_TYPE_ORF = 7;
    public static final int IMAGE_TYPE_PEF = 8;
    public static final int IMAGE_TYPE_PNG = 13;
    public static final int IMAGE_TYPE_RAF = 9;
    public static final int IMAGE_TYPE_RW2 = 10;
    public static final int IMAGE_TYPE_SRW = 11;
    public static final int IMAGE_TYPE_UNKNOWN = 0;
    public static final int IMAGE_TYPE_WEBP = 14;
    public static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    public static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
    public static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final byte MARKER = -1;
    public static final byte MARKER_APP1 = -31;
    public static final byte MARKER_COM = -2;
    public static final byte MARKER_EOI = -39;
    public static final byte MARKER_SOF0 = -64;
    public static final byte MARKER_SOF1 = -63;
    public static final byte MARKER_SOF10 = -54;
    public static final byte MARKER_SOF11 = -53;
    public static final byte MARKER_SOF13 = -51;
    public static final byte MARKER_SOF14 = -50;
    public static final byte MARKER_SOF15 = -49;
    public static final byte MARKER_SOF2 = -62;
    public static final byte MARKER_SOF3 = -61;
    public static final byte MARKER_SOF5 = -59;
    public static final byte MARKER_SOF6 = -58;
    public static final byte MARKER_SOF7 = -57;
    public static final byte MARKER_SOF9 = -55;
    public static final byte MARKER_SOI = -40;
    public static final byte MARKER_SOS = -38;
    public static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    public static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, 4)};
    public static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
    public static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    public static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    public static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    public static final ExifTag[] ORF_MAKER_NOTE_TAGS = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
    public static final short ORF_SIGNATURE_1 = 20306;
    public static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    public static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    public static final String PEF_SIGNATURE = "PENTAX";
    public static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    public static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    public static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    public static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    public static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    public static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    public static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    public static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    public static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    public static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
    public static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final int SIGNATURE_CHECK_SIZE = 5000;
    public static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    public static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    public static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, AudioAttributesCompat.FLAG_ALL_PUBLIC, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    public static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    public static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    public static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    public static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    public static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    public static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    public static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    public static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    public static final byte WEBP_VP8L_SIGNATURE = 47;
    public static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    public static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    public static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    public static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    public static SimpleDateFormat sFormatter;
    public static final Pattern sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    public static final Pattern sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
    public static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    public boolean mAreThumbnailStripsConsecutive;
    public AssetManager.AssetInputStream mAssetInputStream;
    public final HashMap<String, ExifAttribute>[] mAttributes;
    public Set<Integer> mAttributesOffsets;
    public ByteOrder mExifByteOrder;
    public String mFilename;
    public boolean mHasThumbnail;
    public boolean mHasThumbnailStrips;
    public boolean mIsExifDataOnly;
    public int mMimeType;
    public boolean mModified;
    public int mOffsetToExifData;
    public int mOrfMakerNoteOffset;
    public int mOrfThumbnailLength;
    public int mOrfThumbnailOffset;
    public FileDescriptor mSeekableFileDescriptor;
    public byte[] mThumbnailBytes;
    public int mThumbnailCompression;
    public int mThumbnailLength;
    public int mThumbnailOffset;
    public boolean mXmpIsFromSeparateMarker;

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        public ByteOrder mByteOrder;
        public DataInputStream mDataInputStream;
        public final int mLength;
        public int mPosition;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int getLength() {
            return this.mLength;
        }

        public synchronized void mark(int i2) {
            this.mDataInputStream.mark(i2);
        }

        public int peek() {
            return this.mPosition;
        }

        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        public byte readByte() throws IOException {
            int i2 = this.mPosition + 1;
            this.mPosition = i2;
            if (i2 <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.mPosition + i3;
            this.mPosition = i4;
            if (i4 > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            int i2 = this.mPosition + 4;
            this.mPosition = i2;
            if (i2 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            return null;
        }

        public long readLong() throws IOException {
            int i2 = this.mPosition + 8;
            this.mPosition = i2;
            if (i2 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                int read5 = this.mDataInputStream.read();
                int read6 = this.mDataInputStream.read();
                int read7 = this.mDataInputStream.read();
                int read8 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i3 = read2;
                    if (byteOrder == BIG_ENDIAN) {
                        return (((long) read) << 56) + (((long) i3) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i2 = this.mPosition + 2;
            this.mPosition = i2;
            if (i2 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            int i2 = this.mPosition + 2;
            this.mPosition = i2;
            if (i2 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j) throws IOException {
            int i2 = this.mPosition;
            if (((long) i2) > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j -= (long) i2;
            }
            int i3 = (int) j;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public int skipBytes(int i2) throws IOException {
            int min = Math.min(i2, this.mLength - this.mPosition);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.mDataInputStream.skipBytes(min - i3);
            }
            this.mPosition += i3;
            return i3;
        }

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
            this.mByteOrder = byteOrder;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.mDataInputStream.read(bArr, i2, i3);
            this.mPosition += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }
    }

    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        public ByteOrder mByteOrder;
        public final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void writeByte(int i2) throws IOException {
            this.mOutputStream.write(i2);
        }

        public void writeInt(int i2) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i2 >>> 0) & 255);
                this.mOutputStream.write((i2 >>> 8) & 255);
                this.mOutputStream.write((i2 >>> 16) & 255);
                this.mOutputStream.write((i2 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i2 >>> 24) & 255);
                this.mOutputStream.write((i2 >>> 16) & 255);
                this.mOutputStream.write((i2 >>> 8) & 255);
                this.mOutputStream.write((i2 >>> 0) & 255);
            }
        }

        public void writeShort(short s) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s >>> 0) & 255);
                this.mOutputStream.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s >>> 8) & 255);
                this.mOutputStream.write((s >>> 0) & 255);
            }
        }

        public void writeUnsignedInt(long j) throws IOException {
            writeInt((int) j);
        }

        public void writeUnsignedShort(int i2) throws IOException {
            writeShort((short) i2);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.mOutputStream.write(bArr, i2, i3);
        }
    }

    public static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int i2, int i3, byte[] bArr) {
            this(i2, i3, -1, bArr);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes2 = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, bytes2.length, bytes2);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (value instanceof String) {
                return Double.parseDouble((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (value instanceof String) {
                return Integer.parseInt((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i2 < rationalArr.length) {
                    sb.append(rationalArr[i2].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i2].denominator);
                    i2++;
                    if (i2 != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:140:0x0157 A[SYNTHETIC, Splitter:B:140:0x0157] */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x015e A[SYNTHETIC, Splitter:B:148:0x015e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object getValue(java.nio.ByteOrder r9) {
            /*
                r8 = this;
                r0 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x015b, all -> 0x0154 }
                byte[] r2 = r8.bytes     // Catch:{ IOException -> 0x015b, all -> 0x0154 }
                r1.<init>((byte[]) r2)     // Catch:{ IOException -> 0x015b, all -> 0x0154 }
                r1.setByteOrder(r9)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r9 = r8.format     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r2 = 1
                r3 = 0
                switch(r9) {
                    case 1: goto L_0x011b;
                    case 2: goto L_0x00d1;
                    case 3: goto L_0x00bc;
                    case 4: goto L_0x00a7;
                    case 5: goto L_0x0089;
                    case 6: goto L_0x011b;
                    case 7: goto L_0x00d1;
                    case 8: goto L_0x0074;
                    case 9: goto L_0x005f;
                    case 10: goto L_0x003f;
                    case 11: goto L_0x0029;
                    case 12: goto L_0x0014;
                    default: goto L_0x0012;
                }     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x0012:
                goto L_0x014d
            L_0x0014:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x0018:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x0025
                double r4 = r1.readDouble()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r4     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x0018
            L_0x0025:
                r1.close()     // Catch:{ IOException -> 0x0028 }
            L_0x0028:
                return r9
            L_0x0029:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x002d:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x003b
                float r2 = r1.readFloat()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                double r4 = (double) r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r4     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x002d
            L_0x003b:
                r1.close()     // Catch:{ IOException -> 0x003e }
            L_0x003e:
                return r9
            L_0x003f:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                androidx.exifinterface.media.ExifInterface$Rational[] r9 = new androidx.exifinterface.media.ExifInterface.Rational[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x0043:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x005b
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                long r4 = (long) r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                long r6 = (long) r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                androidx.exifinterface.media.ExifInterface$Rational r2 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x0043
            L_0x005b:
                r1.close()     // Catch:{ IOException -> 0x005e }
            L_0x005e:
                return r9
            L_0x005f:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x0063:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x0070
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x0063
            L_0x0070:
                r1.close()     // Catch:{ IOException -> 0x0073 }
            L_0x0073:
                return r9
            L_0x0074:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x0078:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x0085
                short r2 = r1.readShort()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x0078
            L_0x0085:
                r1.close()     // Catch:{ IOException -> 0x0088 }
            L_0x0088:
                return r9
            L_0x0089:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                androidx.exifinterface.media.ExifInterface$Rational[] r9 = new androidx.exifinterface.media.ExifInterface.Rational[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x008d:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x00a3
                long r4 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                long r6 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                androidx.exifinterface.media.ExifInterface$Rational r2 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x008d
            L_0x00a3:
                r1.close()     // Catch:{ IOException -> 0x00a6 }
            L_0x00a6:
                return r9
            L_0x00a7:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                long[] r9 = new long[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x00ab:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x00b8
                long r4 = r1.readUnsignedInt()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r4     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x00ab
            L_0x00b8:
                r1.close()     // Catch:{ IOException -> 0x00bb }
            L_0x00bb:
                return r9
            L_0x00bc:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x00c0:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x00cd
                int r2 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9[r3] = r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r3 + 1
                goto L_0x00c0
            L_0x00cd:
                r1.close()     // Catch:{ IOException -> 0x00d0 }
            L_0x00d0:
                return r9
            L_0x00d1:
                int r9 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte[] r4 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r4 = r4.length     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r9 < r4) goto L_0x00f2
                r9 = 0
            L_0x00d9:
                byte[] r4 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r4 = r4.length     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r9 >= r4) goto L_0x00ed
                byte[] r4 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte r4 = r4[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte[] r5 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte r5 = r5[r9]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r4 == r5) goto L_0x00ea
                r2 = 0
                goto L_0x00ed
            L_0x00ea:
                int r9 = r9 + 1
                goto L_0x00d9
            L_0x00ed:
                if (r2 == 0) goto L_0x00f2
                byte[] r9 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r3 = r9.length     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x00f2:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9.<init>()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x00f7:
                int r2 = r8.numberOfComponents     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r3 >= r2) goto L_0x0113
                byte[] r2 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte r2 = r2[r3]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r2 != 0) goto L_0x0102
                goto L_0x0113
            L_0x0102:
                r4 = 32
                if (r2 < r4) goto L_0x010b
                char r2 = (char) r2     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9.append(r2)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                goto L_0x0110
            L_0x010b:
                r2 = 63
                r9.append(r2)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
            L_0x0110:
                int r3 = r3 + 1
                goto L_0x00f7
            L_0x0113:
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r1.close()     // Catch:{ IOException -> 0x011a }
            L_0x011a:
                return r9
            L_0x011b:
                byte[] r9 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r9 = r9.length     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r9 != r2) goto L_0x0140
                byte[] r9 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r9 < 0) goto L_0x0140
                byte[] r9 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                if (r9 > r2) goto L_0x0140
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                char[] r2 = new char[r2]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte[] r4 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte r4 = r4[r3]     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                int r4 = r4 + 48
                char r4 = (char) r4     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r2[r3] = r4     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9.<init>(r2)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r1.close()     // Catch:{ IOException -> 0x013f }
            L_0x013f:
                return r9
            L_0x0140:
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                byte[] r2 = r8.bytes     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                java.nio.charset.Charset r3 = androidx.exifinterface.media.ExifInterface.ASCII     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r9.<init>(r2, r3)     // Catch:{ IOException -> 0x015c, all -> 0x0151 }
                r1.close()     // Catch:{ IOException -> 0x014c }
            L_0x014c:
                return r9
            L_0x014d:
                r1.close()     // Catch:{ IOException -> 0x0150 }
            L_0x0150:
                return r0
            L_0x0151:
                r9 = move-exception
                r0 = r1
                goto L_0x0155
            L_0x0154:
                r9 = move-exception
            L_0x0155:
                if (r0 == 0) goto L_0x015a
                r0.close()     // Catch:{ IOException -> 0x015a }
            L_0x015a:
                throw r9
            L_0x015b:
                r1 = r0
            L_0x015c:
                if (r1 == 0) goto L_0x0161
                r1.close()     // Catch:{ IOException -> 0x0161 }
            L_0x0161:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public ExifAttribute(int i2, int i3, long j, byte[] bArr) {
            this.format = i2;
            this.numberOfComponents = i3;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public static ExifAttribute createSLong(int i2, ByteOrder byteOrder) {
            return createSLong(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createUShort(int i2, ByteOrder byteOrder) {
            return createUShort(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(double d) {
            this((long) (d * 10000.0d), 10000);
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = IFD_TIFF_TAGS;
        EXIF_TAGS = new ExifTag[][]{exifTagArr2, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, exifTagArr2, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, exifTagArr};
        ExifTag[][] exifTagArr3 = EXIF_TAGS;
        sExifTagMapsForReading = new HashMap[exifTagArr3.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr3.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            sExifTagMapsForReading[i2] = new HashMap<>();
            sExifTagMapsForWriting[i2] = new HashMap<>();
            for (ExifTag exifTag : EXIF_TAGS[i2]) {
                sExifTagMapsForReading[i2].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i2].put(exifTag.name, exifTag);
            }
        }
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[0].number), 5);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[1].number), 1);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[2].number), 2);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[3].number), 3);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[4].number), 7);
        sExifPointerTagMap.put(Integer.valueOf(EXIF_POINTER_TAGS[5].number), 8);
    }

    public ExifInterface(@NonNull File file) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return sb.toString();
    }

    public static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.close(fileDescriptor);
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - ((double) j);
        long j2 = (long) (d2 * 60.0d);
        long round = Math.round((d2 - (((double) j2) / 60.0d)) * 3600.0d * 1.0E7d);
        return j + "/1," + j2 + "/1," + round + "/10000000";
    }

    public static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH)) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static long[] convertToLongArray(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                sb.append(new String(bArr, ASCII));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, ASCII);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (str != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                boolean z = DEBUG;
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
                ExifAttribute exifAttribute = this.mAttributes[i2].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private void getHeifAttributes(final ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        String str;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new MediaDataSource() {
                    public long mPosition;

                    public void close() throws IOException {
                    }

                    public long getSize() throws IOException {
                        return -1;
                    }

                    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
                        if (i3 == 0) {
                            return 0;
                        }
                        if (j < 0) {
                            return -1;
                        }
                        try {
                            if (this.mPosition != j) {
                                if (this.mPosition >= 0 && j >= this.mPosition + ((long) byteOrderedDataInputStream.available())) {
                                    return -1;
                                }
                                byteOrderedDataInputStream.seek(j);
                                this.mPosition = j;
                            }
                            if (i3 > byteOrderedDataInputStream.available()) {
                                i3 = byteOrderedDataInputStream.available();
                            }
                            int read = byteOrderedDataInputStream.read(bArr, i2, i3);
                            if (read >= 0) {
                                this.mPosition += (long) read;
                                return read;
                            }
                        } catch (IOException unused) {
                        }
                        this.mPosition = -1;
                        return -1;
                    }
                });
            } else if (this.mSeekableFileDescriptor != null) {
                mediaMetadataRetriever.setDataSource(this.mSeekableFileDescriptor);
            } else if (this.mFilename != null) {
                mediaMetadataRetriever.setDataSource(this.mFilename);
            } else {
                mediaMetadataRetriever.release();
                return;
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            String str3 = null;
            if ("yes".equals(extractMetadata3)) {
                str3 = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str3 = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str2 = null;
                str = null;
            }
            if (str3 != null) {
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createUShort(Integer.parseInt(str3), this.mExifByteOrder));
            }
            if (str2 != null) {
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createUShort(Integer.parseInt(str2), this.mExifByteOrder));
            }
            if (str != null) {
                int i2 = 1;
                int parseInt = Integer.parseInt(str);
                if (parseInt == 90) {
                    i2 = 6;
                } else if (parseInt == 180) {
                    i2 = 3;
                } else if (parseInt == 270) {
                    i2 = 8;
                }
                this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createUShort(i2, this.mExifByteOrder));
            }
            if (!(extractMetadata == null || extractMetadata2 == null)) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    byteOrderedDataInputStream.seek((long) parseInt2);
                    byte[] bArr = new byte[6];
                    if (byteOrderedDataInputStream.read(bArr) == 6) {
                        int i3 = parseInt2 + 6;
                        int i4 = parseInt3 - 6;
                        if (Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                            byte[] bArr2 = new byte[i4];
                            if (byteOrderedDataInputStream.read(bArr2) == i4) {
                                this.mOffsetToExifData = i3;
                                readExifSegment(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (DEBUG) {
                "Heif meta: " + str3 + x.a + str2 + ", rotation " + str;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0188 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r20, int r21, int r22) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x001a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getJpegAttributes starting with: "
            r3.append(r4)
            r3.append(r1)
            r3.toString()
        L_0x001a:
            r3 = 0
            r1.mark(r3)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN
            r1.setByteOrder(r4)
            byte r4 = r20.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r4 != r6) goto L_0x01d2
            byte r7 = r20.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01b7
            r4 = 2
            r5 = 2
        L_0x0036:
            byte r7 = r20.readByte()
            if (r7 != r6) goto L_0x019a
            r7 = 1
            int r5 = r5 + r7
            byte r8 = r20.readByte()
            boolean r9 = DEBUG
            if (r9 == 0) goto L_0x005c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Found JPEG segment indicator: "
            r9.append(r10)
            r10 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r9.append(r10)
            r9.toString()
        L_0x005c:
            int r5 = r5 + r7
            r9 = -39
            if (r8 == r9) goto L_0x0194
            r9 = -38
            if (r8 != r9) goto L_0x0067
            goto L_0x0194
        L_0x0067:
            int r9 = r20.readUnsignedShort()
            int r9 = r9 - r4
            int r5 = r5 + r4
            boolean r10 = DEBUG
            if (r10 == 0) goto L_0x0096
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "JPEG segment: "
            r10.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r11 = " (length: "
            r10.append(r11)
            int r11 = r9 + 2
            r10.append(r11)
            java.lang.String r11 = ")"
            r10.append(r11)
            r10.toString()
        L_0x0096:
            java.lang.String r10 = "Invalid length"
            if (r9 < 0) goto L_0x018e
            r11 = -31
            if (r8 == r11) goto L_0x0114
            r11 = -2
            if (r8 == r11) goto L_0x00e9
            switch(r8) {
                case -64: goto L_0x00af;
                case -63: goto L_0x00af;
                case -62: goto L_0x00af;
                case -61: goto L_0x00af;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            switch(r8) {
                case -59: goto L_0x00af;
                case -58: goto L_0x00af;
                case -57: goto L_0x00af;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            switch(r8) {
                case -55: goto L_0x00af;
                case -54: goto L_0x00af;
                case -53: goto L_0x00af;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            switch(r8) {
                case -51: goto L_0x00af;
                case -50: goto L_0x00af;
                case -49: goto L_0x00af;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            goto L_0x0172
        L_0x00af:
            int r8 = r1.skipBytes(r7)
            if (r8 != r7) goto L_0x00e1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r0.mAttributes
            r7 = r7[r2]
            int r8 = r20.readUnsignedShort()
            long r11 = (long) r8
            java.nio.ByteOrder r8 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r11, (java.nio.ByteOrder) r8)
            java.lang.String r11 = "ImageLength"
            r7.put(r11, r8)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r0.mAttributes
            r7 = r7[r2]
            int r8 = r20.readUnsignedShort()
            long r11 = (long) r8
            java.nio.ByteOrder r8 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r11, (java.nio.ByteOrder) r8)
            java.lang.String r11 = "ImageWidth"
            r7.put(r11, r8)
            int r9 = r9 + -5
            goto L_0x0172
        L_0x00e1:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid SOFx"
            r1.<init>(r2)
            throw r1
        L_0x00e9:
            byte[] r8 = new byte[r9]
            int r11 = r1.read(r8)
            if (r11 != r9) goto L_0x010c
            java.lang.String r9 = "UserComment"
            java.lang.String r11 = r0.getAttribute(r9)
            if (r11 != 0) goto L_0x0171
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r11 = r0.mAttributes
            r7 = r11[r7]
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r12 = ASCII
            r11.<init>(r8, r12)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r11)
            r7.put(r9, r8)
            goto L_0x0171
        L_0x010c:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0114:
            byte[] r8 = new byte[r9]
            r1.readFully(r8)
            int r11 = r5 + r9
            byte[] r12 = IDENTIFIER_EXIF_APP1
            boolean r12 = startsWith(r8, r12)
            if (r12 == 0) goto L_0x013e
            byte[] r7 = IDENTIFIER_EXIF_APP1
            int r7 = r7.length
            byte[] r7 = java.util.Arrays.copyOfRange(r8, r7, r9)
            int r5 = r21 + r5
            byte[] r8 = IDENTIFIER_EXIF_APP1
            int r8 = r8.length
            int r5 = r5 + r8
            r0.mOffsetToExifData = r5
            r0.readExifSegment(r7, r2)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r5.<init>((byte[]) r7)
            r0.setThumbnailData(r5)
            goto L_0x0170
        L_0x013e:
            byte[] r12 = IDENTIFIER_XMP_APP1
            boolean r12 = startsWith(r8, r12)
            if (r12 == 0) goto L_0x0170
            byte[] r12 = IDENTIFIER_XMP_APP1
            int r13 = r12.length
            int r5 = r5 + r13
            int r12 = r12.length
            byte[] r8 = java.util.Arrays.copyOfRange(r8, r12, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r12 = r0.getAttribute(r9)
            if (r12 != 0) goto L_0x0170
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r12 = r0.mAttributes
            r12 = r12[r3]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r15 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            r14 = 1
            int r13 = r8.length
            long r3 = (long) r5
            r5 = r13
            r13 = r15
            r6 = r15
            r15 = r5
            r16 = r3
            r18 = r8
            r13.<init>(r14, r15, r16, r18)
            r12.put(r9, r6)
            r0.mXmpIsFromSeparateMarker = r7
        L_0x0170:
            r5 = r11
        L_0x0171:
            r9 = 0
        L_0x0172:
            if (r9 < 0) goto L_0x0188
            int r3 = r1.skipBytes(r9)
            if (r3 != r9) goto L_0x0180
            int r5 = r5 + r9
            r3 = 0
            r4 = 2
            r6 = -1
            goto L_0x0036
        L_0x0180:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid JPEG segment"
            r1.<init>(r2)
            throw r1
        L_0x0188:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r10)
            throw r1
        L_0x018e:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r10)
            throw r1
        L_0x0194:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            r1.setByteOrder(r2)
            return
        L_0x019a:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b7:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d2:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        return isWebpFormat(bArr) ? 14 : 0;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = new byte[ORF_MAKER_NOTE_HEADER_1.length];
            byteOrderedDataInputStream2.readFully(bArr);
            byteOrderedDataInputStream2.seek(0);
            byte[] bArr2 = new byte[ORF_MAKER_NOTE_HEADER_2.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            if (Arrays.equals(bArr, ORF_MAKER_NOTE_HEADER_1)) {
                byteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr2, ORF_MAKER_NOTE_HEADER_2)) {
                byteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    "Invalid aspect frame values. frame=" + Arrays.toString(iArr);
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i3, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                }
            }
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            "getPngAttributes starting with: " + byteOrderedDataInputStream;
        }
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.skipBytes(PNG_SIGNATURE.length);
        int length = PNG_SIGNATURE.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i2 = length + 4;
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int i3 = i2 + 4;
                    if (i3 == 16) {
                        if (!Arrays.equals(bArr, PNG_CHUNK_TYPE_IHDR)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr, PNG_CHUNK_TYPE_IEND)) {
                        if (Arrays.equals(bArr, PNG_CHUNK_TYPE_EXIF)) {
                            byte[] bArr2 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr2) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr);
                                crc32.update(bArr2);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.mOffsetToExifData = i3;
                                    readExifSegment(bArr2, 0);
                                    validateImages();
                                    setThumbnailData(new ByteOrderedDataInputStream(bArr2));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr));
                        }
                        int i4 = readInt + 4;
                        byteOrderedDataInputStream.skipBytes(i4);
                        length = i3 + i4;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            "getRafAttributes starting with: " + byteOrderedDataInputStream;
        }
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        byteOrderedDataInputStream.seek((long) i2);
        byteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i2, 5);
        byteOrderedDataInputStream.seek((long) i4);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (DEBUG) {
            "numberOfDirectoryEntry: " + readInt;
        }
        for (int i5 = 0; i5 < readInt; i5++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort((int) readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort((int) readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                if (DEBUG) {
                    "Updated to length: " + readShort + ", width: " + readShort2;
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byteOrderedDataInputStream2.seek(6);
            readImageFileDirectory(byteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (exifAttribute2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
            }
        }
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            "getRw2Attributes starting with: " + byteOrderedDataInputStream;
        }
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute2);
        }
    }

    private void getStandaloneAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(IDENTIFIER_EXIF_APP1.length);
        byte[] bArr = new byte[byteOrderedDataInputStream.available()];
        byteOrderedDataInputStream.readFully(bArr);
        this.mOffsetToExifData = IDENTIFIER_EXIF_APP1.length;
        readExifSegment(bArr, 0);
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            "getWebpAttributes starting with: " + byteOrderedDataInputStream;
        }
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        int skipBytes = byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_2.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i2 = skipBytes + 4 + 4;
                    if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr2) == readInt2) {
                            this.mOffsetToExifData = i2;
                            readExifSegment(bArr2, 0);
                            setThumbnailData(new ByteOrderedDataInputStream(bArr2));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i3 = i2 + readInt2;
                    if (i3 != readInt) {
                        if (i3 <= readInt) {
                            int skipBytes2 = byteOrderedDataInputStream.skipBytes(readInt2);
                            if (skipBytes2 == readInt2) {
                                skipBytes = i2 + skipBytes2;
                            } else {
                                throw new IOException("Encountered WebP file with invalid chunk size");
                            }
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = guessDataFormat(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = guessDataFormat(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = -1
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = -1
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = 10
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x00f5
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r4 = 5
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x00eb
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r0.<init>(r12, r1)     // Catch:{ NumberFormatException -> 0x00ff }
            return r0
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            r0.<init>(r12, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r0
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r3 = 4
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0130
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r4 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r4 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair");
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                intValue += this.mOrfMakerNoteOffset;
            }
            int min = Math.min(intValue2, byteOrderedDataInputStream.getLength() - intValue);
            if (intValue > 0 && min > 0) {
                this.mHasThumbnail = true;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[min];
                    byteOrderedDataInputStream.skip((long) intValue);
                    byteOrderedDataInputStream.read(bArr);
                    this.mThumbnailBytes = bArr;
                }
                this.mThumbnailOffset = intValue;
                this.mThumbnailLength = min;
            }
            if (DEBUG) {
                "Setting thumbnail attributes with offset: " + intValue + ", length: " + min;
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
        HashMap hashMap2 = hashMap;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap2.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap2.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray != null && convertToLongArray.length != 0 && convertToLongArray2 != null && convertToLongArray2.length != 0 && convertToLongArray.length == convertToLongArray2.length) {
                long j = 0;
                for (long j2 : convertToLongArray2) {
                    j += j2;
                }
                int i2 = (int) j;
                byte[] bArr = new byte[i2];
                int i3 = 1;
                this.mAreThumbnailStripsConsecutive = true;
                this.mHasThumbnailStrips = true;
                this.mHasThumbnail = true;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < convertToLongArray.length) {
                    int i7 = (int) convertToLongArray[i4];
                    int i8 = (int) convertToLongArray2[i4];
                    if (i4 < convertToLongArray.length - i3 && ((long) (i7 + i8)) != convertToLongArray[i4 + 1]) {
                        this.mAreThumbnailStripsConsecutive = false;
                    }
                    int i9 = i7 - i5;
                    if (i9 >= 0) {
                        long j3 = (long) i9;
                        if (byteOrderedDataInputStream2.skip(j3) != j3) {
                            "Failed to skip " + i9 + " bytes.";
                            return;
                        }
                        int i10 = i5 + i9;
                        byte[] bArr2 = new byte[i8];
                        if (byteOrderedDataInputStream2.read(bArr2) != i8) {
                            "Failed to read " + i8 + " bytes.";
                            return;
                        }
                        i5 = i10 + i8;
                        System.arraycopy(bArr2, 0, bArr, i6, i8);
                        i6 += i8;
                        i4++;
                        i3 = 1;
                    } else {
                        return;
                    }
                }
                this.mThumbnailBytes = bArr;
                if (this.mAreThumbnailStripsConsecutive) {
                    this.mThumbnailOffset = (int) convertToLongArray[0];
                    this.mThumbnailLength = i2;
                }
            }
        }
    }

    private void initForFilename(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (isSeekableFD(fileInputStream2.getFD())) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    closeQuietly(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    public static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(IDENTIFIER_EXIF_APP1.length);
        byte[] bArr = new byte[IDENTIFIER_EXIF_APP1.length];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i2 = 0;
        while (true) {
            byte[] bArr2 = IDENTIFIER_EXIF_APP1;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0090, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isHeifFormat(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x008c }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008c }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = HEIF_TYPE_FTYP     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 16
            r7 = 8
            r9 = 1
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r11 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r5 = r7
        L_0x0035:
            int r11 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r11 = (long) r11     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r5
            int r15 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = HEIF_BRAND_MIF1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r7 = 1
            goto L_0x0077
        L_0x006e:
            byte[] r11 = HEIF_BRAND_HEIC     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r8 = 1
        L_0x0077:
            if (r7 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r5 = r5 + r9
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x0093
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x0094
        L_0x0088:
            r1 = r2
            goto L_0x008c
        L_0x008a:
            r15 = move-exception
            goto L_0x0094
        L_0x008c:
            boolean r15 = DEBUG     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            return r0
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isHeifFormat(byte[]):boolean");
    }

    public static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isOrfFormat(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002e
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
        L_0x002e:
            if (r1 == 0) goto L_0x0033
            r1.close()
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isOrfFormat(byte[]):boolean");
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isRw2Format(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x002a
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isRw2Format(byte[]):boolean");
    }

    public static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                boolean z = DEBUG;
            }
        }
        return false;
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int intValue;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            if (Arrays.equals(BITS_PER_SAMPLE_RGB, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, BITS_PER_SAMPLE_RGB)))) {
                return true;
            }
        }
        boolean z = DEBUG;
        return false;
    }

    private boolean isSupportedFormatForSavingAttributes() {
        int i2 = this.mMimeType;
        return i2 == 4 || i2 == 13 || i2 == 14;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c = 10;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c = 9;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals("image/heic")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals("image/heif")) {
                        c = 12;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals("image/jpeg")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals("image/webp")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c = 1;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c = 6;
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals("image/png")) {
                        c = CharUtils.CR;
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new NullPointerException("mimeType shouldn't be null");
        }
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i2 >= bArr2.length) {
                int i3 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i3 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i3 + 4] != bArr3[i3]) {
                        return false;
                    }
                    i3++;
                }
            } else if (bArr[i2] != bArr2[i2]) {
                return false;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:47|48|49|(1:71)) */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5 = DEBUG;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ab, code lost:
        addDefaultValuesForCompatibility();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b0, code lost:
        if (DEBUG != false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b2, code lost:
        printAttributes();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b5, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x009e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAttributes(@androidx.annotation.NonNull java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00b6
            r0 = 0
            r1 = 0
        L_0x0004:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r2 = EXIF_TAGS     // Catch:{ IOException -> 0x009e }
            int r2 = r2.length     // Catch:{ IOException -> 0x009e }
            if (r1 >= r2) goto L_0x0015
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r4.mAttributes     // Catch:{ IOException -> 0x009e }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x009e }
            r3.<init>()     // Catch:{ IOException -> 0x009e }
            r2[r1] = r3     // Catch:{ IOException -> 0x009e }
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0015:
            boolean r1 = r4.mIsExifDataOnly     // Catch:{ IOException -> 0x009e }
            if (r1 != 0) goto L_0x0027
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009e }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x009e }
            int r5 = r4.getMimeType(r1)     // Catch:{ IOException -> 0x009e }
            r4.mMimeType = r5     // Catch:{ IOException -> 0x009e }
            r5 = r1
        L_0x0027:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r1 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x009e }
            r1.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x009e }
            boolean r5 = r4.mIsExifDataOnly     // Catch:{ IOException -> 0x009e }
            if (r5 != 0) goto L_0x0088
            int r5 = r4.mMimeType     // Catch:{ IOException -> 0x009e }
            switch(r5) {
                case 0: goto L_0x0084;
                case 1: goto L_0x0084;
                case 2: goto L_0x0084;
                case 3: goto L_0x0084;
                case 4: goto L_0x0076;
                case 5: goto L_0x0084;
                case 6: goto L_0x0084;
                case 7: goto L_0x0072;
                case 8: goto L_0x0084;
                case 9: goto L_0x0064;
                case 10: goto L_0x0056;
                case 11: goto L_0x0084;
                case 12: goto L_0x0052;
                case 13: goto L_0x0044;
                case 14: goto L_0x0036;
                default: goto L_0x0035;
            }     // Catch:{ IOException -> 0x009e }
        L_0x0035:
            goto L_0x008b
        L_0x0036:
            r4.getWebpAttributes(r1)     // Catch:{ IOException -> 0x009e }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0043
            r4.printAttributes()
        L_0x0043:
            return
        L_0x0044:
            r4.getPngAttributes(r1)     // Catch:{ IOException -> 0x009e }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0051
            r4.printAttributes()
        L_0x0051:
            return
        L_0x0052:
            r4.getHeifAttributes(r1)     // Catch:{ IOException -> 0x009e }
            goto L_0x008b
        L_0x0056:
            r4.getRw2Attributes(r1)     // Catch:{ IOException -> 0x009e }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0063
            r4.printAttributes()
        L_0x0063:
            return
        L_0x0064:
            r4.getRafAttributes(r1)     // Catch:{ IOException -> 0x009e }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0071
            r4.printAttributes()
        L_0x0071:
            return
        L_0x0072:
            r4.getOrfAttributes(r1)     // Catch:{ IOException -> 0x009e }
            goto L_0x008b
        L_0x0076:
            r4.getJpegAttributes(r1, r0, r0)     // Catch:{ IOException -> 0x009e }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0083
            r4.printAttributes()
        L_0x0083:
            return
        L_0x0084:
            r4.getRawAttributes(r1)     // Catch:{ IOException -> 0x009e }
            goto L_0x008b
        L_0x0088:
            r4.getStandaloneAttributes(r1)     // Catch:{ IOException -> 0x009e }
        L_0x008b:
            int r5 = r4.mOffsetToExifData     // Catch:{ IOException -> 0x009e }
            long r2 = (long) r5     // Catch:{ IOException -> 0x009e }
            r1.seek(r2)     // Catch:{ IOException -> 0x009e }
            r4.setThumbnailData(r1)     // Catch:{ IOException -> 0x009e }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x00aa
            goto L_0x00a7
        L_0x009c:
            r5 = move-exception
            goto L_0x00ab
        L_0x009e:
            boolean r5 = DEBUG     // Catch:{ all -> 0x009c }
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x00aa
        L_0x00a7:
            r4.printAttributes()
        L_0x00aa:
            return
        L_0x00ab:
            r4.addDefaultValuesForCompatibility()
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x00b5
            r4.printAttributes()
        L_0x00b5:
            throw r5
        L_0x00b6:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.loadAttributes(java.io.InputStream):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|(5:11|12|(2:14|15)|17|(3:21|(1:23)|24))|(5:26|27|(2:30|28)|37|31)|32|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if ("-".equals(r1) != false) goto L_0x004e;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0082 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Long parseDateTime(@androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0087
            java.util.regex.Pattern r1 = sNonZeroTimePattern
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x0011
            goto L_0x0087
        L_0x0011:
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            java.text.SimpleDateFormat r3 = sFormatter     // Catch:{ IllegalArgumentException -> 0x0087 }
            java.util.Date r10 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0087 }
            if (r10 != 0) goto L_0x0020
            return r0
        L_0x0020:
            long r3 = r10.getTime()     // Catch:{ IllegalArgumentException -> 0x0087 }
            if (r12 == 0) goto L_0x0071
            r10 = 1
            java.lang.String r1 = r12.substring(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0087 }
            r2 = 3
            java.lang.String r5 = r12.substring(r10, r2)     // Catch:{ IllegalArgumentException -> 0x0087 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x0087 }
            r6 = 6
            r7 = 4
            java.lang.String r6 = r12.substring(r7, r6)     // Catch:{ IllegalArgumentException -> 0x0087 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x0087 }
            java.lang.String r8 = "+"
            boolean r8 = r8.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0087 }
            java.lang.String r9 = "-"
            if (r8 != 0) goto L_0x004e
            boolean r8 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0087 }
            if (r8 == 0) goto L_0x0071
        L_0x004e:
            java.lang.String r8 = ":"
            java.lang.String r12 = r12.substring(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0087 }
            boolean r12 = r8.equals(r12)     // Catch:{ IllegalArgumentException -> 0x0087 }
            if (r12 == 0) goto L_0x0071
            r12 = 14
            if (r5 > r12) goto L_0x0071
            int r5 = r5 * 60
            int r5 = r5 + r6
            int r5 = r5 * 60
            int r5 = r5 * 1000
            boolean r12 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0087 }
            if (r12 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r10 = -1
        L_0x006d:
            int r5 = r5 * r10
            long r1 = (long) r5
            long r3 = r3 + r1
        L_0x0071:
            if (r11 == 0) goto L_0x0082
            long r10 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x0082 }
        L_0x0077:
            r1 = 1000(0x3e8, double:4.94E-321)
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 <= 0) goto L_0x0081
            r1 = 10
            long r10 = r10 / r1
            goto L_0x0077
        L_0x0081:
            long r3 = r3 + r10
        L_0x0082:
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0087 }
            return r10
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.parseDateTime(java.lang.String, java.lang.String, java.lang.String):java.lang.Long");
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i3 = this.mMimeType;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i4 = readInt - 8;
            if (i4 > 0 && byteOrderedDataInputStream.skipBytes(i4) != i4) {
                throw new IOException("Couldn't jump to first Ifd: " + i4);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void printAttributes() {
        for (int i2 = 0; i2 < this.mAttributes.length; i2++) {
            "The size of tag group[" + i2 + "]: " + this.mAttributes[i2].size();
            for (Map.Entry next : this.mAttributes[i2].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                "tagName: " + ((String) next.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.getStringValue(this.mExifByteOrder) + "'";
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            boolean z = DEBUG;
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            boolean z2 = DEBUG;
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void readExifSegment(byte[] bArr, int i2) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
        readImageFileDirectory(byteOrderedDataInputStream, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0254  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r27, int r28) throws java.io.IOException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = r1.mPosition
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.mPosition
            r4 = 2
            int r3 = r3 + r4
            int r5 = r1.mLength
            if (r3 <= r5) goto L_0x001a
            return
        L_0x001a:
            short r3 = r27.readShort()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0032
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "numberOfDirectoryEntry: "
            r5.append(r6)
            r5.append(r3)
            r5.toString()
        L_0x0032:
            int r5 = r1.mPosition
            int r6 = r3 * 12
            int r5 = r5 + r6
            int r6 = r1.mLength
            if (r5 > r6) goto L_0x03cc
            if (r3 > 0) goto L_0x003f
            goto L_0x03cc
        L_0x003f:
            r5 = 0
            r6 = 0
        L_0x0041:
            r7 = 5
            r10 = 1
            if (r6 >= r3) goto L_0x034b
            int r12 = r27.readUnsignedShort()
            int r13 = r27.readUnsignedShort()
            int r15 = r27.readInt()
            int r14 = r27.peek()
            long r8 = (long) r14
            r18 = 4
            long r8 = r8 + r18
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r14 = sExifTagMapsForReading
            r14 = r14[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            java.lang.Object r11 = r14.get(r11)
            androidx.exifinterface.media.ExifInterface$ExifTag r11 = (androidx.exifinterface.media.ExifInterface.ExifTag) r11
            boolean r14 = DEBUG
            r4 = 3
            if (r14 == 0) goto L_0x0098
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r28)
            r7[r5] = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)
            r7[r10] = r14
            if (r11 == 0) goto L_0x0080
            java.lang.String r14 = r11.name
            goto L_0x0081
        L_0x0080:
            r14 = 0
        L_0x0081:
            r21 = 2
            r7[r21] = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)
            r7[r4] = r14
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            r20 = 4
            r7[r20] = r14
            java.lang.String r14 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String.format(r14, r7)
        L_0x0098:
            r7 = 7
            if (r11 != 0) goto L_0x00b5
            boolean r14 = DEBUG
            if (r14 == 0) goto L_0x00af
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r10 = "Skip the tag entry since tag number is not defined: "
            r14.append(r10)
            r14.append(r12)
            r14.toString()
        L_0x00af:
            r22 = r6
            r23 = r11
            goto L_0x0133
        L_0x00b5:
            if (r13 <= 0) goto L_0x011b
            int[] r10 = IFD_FORMAT_BYTES_PER_FORMAT
            int r10 = r10.length
            if (r13 < r10) goto L_0x00bd
            goto L_0x011b
        L_0x00bd:
            boolean r10 = r11.isFormatCompatible(r13)
            if (r10 != 0) goto L_0x00e6
            boolean r10 = DEBUG
            if (r10 == 0) goto L_0x00af
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r14 = "Skip the tag entry since data format ("
            r10.append(r14)
            java.lang.String[] r14 = IFD_FORMAT_NAMES
            r14 = r14[r13]
            r10.append(r14)
            java.lang.String r14 = ") is unexpected for tag: "
            r10.append(r14)
            java.lang.String r14 = r11.name
            r10.append(r14)
            r10.toString()
            goto L_0x00af
        L_0x00e6:
            if (r13 != r7) goto L_0x00ea
            int r13 = r11.primaryFormat
        L_0x00ea:
            r22 = r6
            long r5 = (long) r15
            int[] r14 = IFD_FORMAT_BYTES_PER_FORMAT
            r14 = r14[r13]
            r23 = r11
            long r10 = (long) r14
            long r5 = r5 * r10
            r10 = 0
            int r14 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r14 < 0) goto L_0x0106
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r14 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r14 <= 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r10 = 1
            goto L_0x0136
        L_0x0106:
            boolean r10 = DEBUG
            if (r10 == 0) goto L_0x0135
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Skip the tag entry since the number of components is invalid: "
            r10.append(r11)
            r10.append(r15)
            r10.toString()
            goto L_0x0135
        L_0x011b:
            r22 = r6
            r23 = r11
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0133
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Skip the tag entry since data format is invalid: "
            r5.append(r6)
            r5.append(r13)
            r5.toString()
        L_0x0133:
            r5 = 0
        L_0x0135:
            r10 = 0
        L_0x0136:
            if (r10 != 0) goto L_0x0140
            r1.seek(r8)
            r23 = r3
        L_0x013d:
            r12 = 2
            goto L_0x0340
        L_0x0140:
            java.lang.String r11 = "Compression"
            int r10 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r10 <= 0) goto L_0x01ef
            int r10 = r27.readInt()
            boolean r14 = DEBUG
            if (r14 == 0) goto L_0x015e
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r4 = "seek to data offset: "
            r14.append(r4)
            r14.append(r10)
            r14.toString()
        L_0x015e:
            int r4 = r0.mMimeType
            if (r4 != r7) goto L_0x01bf
            r4 = r23
            java.lang.String r7 = r4.name
            java.lang.String r14 = "MakerNote"
            boolean r7 = r14.equals(r7)
            if (r7 == 0) goto L_0x0171
            r0.mOrfMakerNoteOffset = r10
            goto L_0x01ba
        L_0x0171:
            r7 = 6
            if (r2 != r7) goto L_0x01ba
            java.lang.String r14 = r4.name
            java.lang.String r7 = "ThumbnailImage"
            boolean r7 = r7.equals(r14)
            if (r7 == 0) goto L_0x01ba
            r0.mOrfThumbnailOffset = r10
            r0.mOrfThumbnailLength = r15
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            r14 = 6
            androidx.exifinterface.media.ExifInterface$ExifAttribute r7 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r14, (java.nio.ByteOrder) r7)
            int r14 = r0.mOrfThumbnailOffset
            r18 = r15
            long r14 = (long) r14
            r23 = r3
            java.nio.ByteOrder r3 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r14, (java.nio.ByteOrder) r3)
            int r14 = r0.mOrfThumbnailLength
            long r14 = (long) r14
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r14, (java.nio.ByteOrder) r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r14 = r0.mAttributes
            r15 = 4
            r14 = r14[r15]
            r14.put(r11, r7)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r0.mAttributes
            r7 = r7[r15]
            java.lang.String r14 = "JPEGInterchangeFormat"
            r7.put(r14, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r15]
            java.lang.String r7 = "JPEGInterchangeFormatLength"
            r3.put(r7, r2)
            goto L_0x01c5
        L_0x01ba:
            r23 = r3
            r18 = r15
            goto L_0x01c5
        L_0x01bf:
            r18 = r15
            r4 = r23
            r23 = r3
        L_0x01c5:
            long r2 = (long) r10
            long r14 = r2 + r5
            int r7 = r1.mLength
            r24 = r5
            r6 = r4
            long r4 = (long) r7
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x01d6
            r1.seek(r2)
            goto L_0x01f7
        L_0x01d6:
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x01ea
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip the tag entry since data offset is invalid: "
            r2.append(r3)
            r2.append(r10)
            r2.toString()
        L_0x01ea:
            r1.seek(r8)
            goto L_0x013d
        L_0x01ef:
            r24 = r5
            r18 = r15
            r6 = r23
            r23 = r3
        L_0x01f7:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = sExifPointerTagMap
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0222
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "nextIfdType: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " byteCount: "
            r3.append(r4)
            r4 = r24
            r3.append(r4)
            r3.toString()
            goto L_0x0224
        L_0x0222:
            r4 = r24
        L_0x0224:
            r3 = 8
            if (r2 == 0) goto L_0x02c7
            r4 = -1
            r7 = 3
            if (r13 == r7) goto L_0x024a
            r7 = 4
            if (r13 == r7) goto L_0x0245
            if (r13 == r3) goto L_0x0240
            r3 = 9
            if (r13 == r3) goto L_0x023b
            r3 = 13
            if (r13 == r3) goto L_0x023b
            goto L_0x024f
        L_0x023b:
            int r3 = r27.readInt()
            goto L_0x024e
        L_0x0240:
            short r3 = r27.readShort()
            goto L_0x024e
        L_0x0245:
            long r4 = r27.readUnsignedInt()
            goto L_0x024f
        L_0x024a:
            int r3 = r27.readUnsignedShort()
        L_0x024e:
            long r4 = (long) r3
        L_0x024f:
            boolean r3 = DEBUG
            r12 = 2
            if (r3 == 0) goto L_0x0267
            java.lang.Object[] r3 = new java.lang.Object[r12]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r10 = 0
            r3[r10] = r7
            java.lang.String r6 = r6.name
            r7 = 1
            r3[r7] = r6
            java.lang.String r6 = "Offset: %d, tagName: %s"
            java.lang.String.format(r6, r3)
        L_0x0267:
            r6 = 0
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x02ae
            int r3 = r1.mLength
            long r6 = (long) r3
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x02ae
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r6 = (int) r4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r3 = r3.contains(r6)
            if (r3 != 0) goto L_0x028c
            r1.seek(r4)
            int r2 = r2.intValue()
            r0.readImageFileDirectory(r1, r2)
            goto L_0x02c2
        L_0x028c:
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x02c2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ")"
            r3.append(r2)
            r3.toString()
            goto L_0x02c2
        L_0x02ae:
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x02c2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r4)
            r2.toString()
        L_0x02c2:
            r1.seek(r8)
            goto L_0x0340
        L_0x02c7:
            r12 = 2
            int r2 = r27.peek()
            int r7 = r0.mOffsetToExifData
            int r2 = r2 + r7
            int r5 = (int) r4
            byte[] r4 = new byte[r5]
            r1.readFully(r4)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            long r14 = (long) r2
            r19 = r14
            r14 = r5
            r2 = r18
            r15 = r13
            r16 = r2
            r17 = r19
            r19 = r4
            r14.<init>(r15, r16, r17, r19)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r28]
            java.lang.String r4 = r6.name
            r2.put(r4, r5)
            java.lang.String r2 = r6.name
            java.lang.String r4 = "DNGVersion"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x02fd
            r2 = 3
            r0.mMimeType = r2
        L_0x02fd:
            java.lang.String r2 = r6.name
            java.lang.String r4 = "Make"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x0311
            java.lang.String r2 = r6.name
            java.lang.String r4 = "Model"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x031f
        L_0x0311:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            java.lang.String r2 = r5.getStringValue(r2)
            java.lang.String r4 = "PENTAX"
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x0332
        L_0x031f:
            java.lang.String r2 = r6.name
            boolean r2 = r11.equals(r2)
            if (r2 == 0) goto L_0x0334
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            int r2 = r5.getIntValue(r2)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r4) goto L_0x0334
        L_0x0332:
            r0.mMimeType = r3
        L_0x0334:
            int r2 = r27.peek()
            long r2 = (long) r2
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0340
            r1.seek(r8)
        L_0x0340:
            int r6 = r22 + 1
            short r6 = (short) r6
            r2 = r28
            r3 = r23
            r4 = 2
            r5 = 0
            goto L_0x0041
        L_0x034b:
            int r2 = r27.peek()
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.mLength
            if (r2 > r3) goto L_0x03cc
            int r2 = r27.readInt()
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x036c
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "nextIfdOffset: %d"
            java.lang.String.format(r4, r3)
        L_0x036c:
            long r3 = (long) r2
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x03b8
            int r5 = r1.mLength
            if (r2 >= r5) goto L_0x03b8
            java.util.Set<java.lang.Integer> r5 = r0.mAttributesOffsets
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x03a3
            r1.seek(r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0395
            r0.readImageFileDirectory(r1, r3)
            goto L_0x03cc
        L_0x0395:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r7]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03cc
            r0.readImageFileDirectory(r1, r7)
            goto L_0x03cc
        L_0x03a3:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x03cc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            r1.toString()
            goto L_0x03cc
        L_0x03b8:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x03cc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            r1.toString()
        L_0x03cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int):void");
    }

    private void removeAttribute(String str) {
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            this.mAttributes[i2].remove(str);
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_JPEG_INTERCHANGE_FORMAT);
            ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
                byteOrderedDataInputStream.seek((long) intValue);
                byte[] bArr = new byte[intValue2];
                byteOrderedDataInputStream.read(bArr);
                getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue, i2);
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")";
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (dataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                ExifAttribute exifAttribute = null;
                if (getAttribute(TAG_XMP) != null && this.mXmpIsFromSeparateMarker) {
                    exifAttribute = this.mAttributes[0].remove(TAG_XMP);
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream);
                if (exifAttribute != null) {
                    this.mAttributes[0].put(TAG_XMP, exifAttribute);
                }
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        copy(dataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                        int i2 = readUnsignedShort - 2;
                        if (i2 >= 0) {
                            while (i2 > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i2 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (dataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                    int i3 = readUnsignedShort2 - 6;
                                    if (dataInputStream.skipBytes(i3) != i3) {
                                        throw new IOException("Invalid length");
                                    }
                                }
                            }
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")";
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        copy(dataInputStream, byteOrderedDataOutputStream, PNG_SIGNATURE.length);
        int i2 = this.mOffsetToExifData;
        if (i2 == 0) {
            int readInt = dataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(readInt);
            copy(dataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
        } else {
            copy(dataInputStream, byteOrderedDataOutputStream, ((i2 - PNG_SIGNATURE.length) - 4) - 4);
            dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, ByteOrder.BIG_ENDIAN);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                closeQuietly(byteArrayOutputStream2);
                copy(dataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01b3 A[Catch:{ Exception -> 0x01fa, all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01bf A[Catch:{ Exception -> 0x01fa, all -> 0x01f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveWebpAttributes(java.io.InputStream r20, java.io.OutputStream r21) throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0027
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "saveWebpAttributes starting with (inputStream: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = ", outputStream: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ")"
            r3.append(r4)
            r3.toString()
        L_0x0027:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
            r3.<init>(r0, r4)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r4 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream
            java.nio.ByteOrder r5 = java.nio.ByteOrder.LITTLE_ENDIAN
            r4.<init>(r2, r5)
            byte[] r2 = WEBP_SIGNATURE_1
            int r2 = r2.length
            copy(r3, r4, r2)
            byte[] r2 = WEBP_SIGNATURE_2
            int r2 = r2.length
            r5 = 4
            int r2 = r2 + r5
            r3.skipBytes(r2)
            r2 = 0
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x01ff }
            r6.<init>()     // Catch:{ Exception -> 0x01ff }
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r7 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.<init>(r6, r8)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r8 = r1.mOffsetToExifData     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r8 == 0) goto L_0x0073
            byte[] r0 = WEBP_SIGNATURE_1     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r0 = r0.length     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r0 = r0 + r5
            byte[] r2 = WEBP_SIGNATURE_2     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r2 = r2.length     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r0 = r0 + r2
            int r2 = r1.mOffsetToExifData     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r2 = r2 - r0
            int r2 = r2 - r5
            int r2 = r2 - r5
            copy(r3, r7, r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r3.skipBytes(r5)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r0 = r3.readInt()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r3.skipBytes(r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            goto L_0x01d5
        L_0x0073:
            byte[] r8 = new byte[r5]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r9 = r3.read(r8)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r9 != r5) goto L_0x01ef
            byte[] r9 = WEBP_CHUNK_TYPE_VP8X     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r9 = java.util.Arrays.equals(r8, r9)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r10 = 8
            r11 = 1
            r12 = 0
            if (r9 == 0) goto L_0x00da
            int r8 = r3.readInt()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r9 = r8 % 2
            if (r9 != r11) goto L_0x0092
            int r9 = r8 + 1
            goto L_0x0093
        L_0x0092:
            r9 = r8
        L_0x0093:
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r3.read(r9)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte r13 = r9[r12]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r10 = r10 | r13
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r9[r12] = r10     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte r10 = r9[r12]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r10 = r10 >> r11
            r10 = r10 & r11
            if (r10 != r11) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r11 = 0
        L_0x00a6:
            byte[] r10 = WEBP_CHUNK_TYPE_VP8X     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.write(r10)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.writeInt(r8)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.write(r9)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r11 == 0) goto L_0x00ce
            byte[] r8 = WEBP_CHUNK_TYPE_ANIM     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r1.copyChunksUpToGivenChunkType(r3, r7, r8, r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        L_0x00b8:
            byte[] r2 = new byte[r5]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r0.read(r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r8 = WEBP_CHUNK_TYPE_ANMF     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r8 = java.util.Arrays.equals(r2, r8)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r8 != 0) goto L_0x00ca
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            goto L_0x01d5
        L_0x00ca:
            r1.copyWebPChunk(r3, r7, r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            goto L_0x00b8
        L_0x00ce:
            byte[] r0 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r2 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r1.copyChunksUpToGivenChunkType(r3, r7, r0, r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            goto L_0x01d5
        L_0x00da:
            byte[] r0 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r0 != 0) goto L_0x00ea
            byte[] r0 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r0 == 0) goto L_0x01d5
        L_0x00ea:
            int r0 = r3.readInt()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r2 = r0 % 2
            if (r2 != r11) goto L_0x00f5
            int r2 = r0 + 1
            goto L_0x00f6
        L_0x00f5:
            r2 = r0
        L_0x00f6:
            r9 = 3
            byte[] r13 = new byte[r9]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r14 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r14 = java.util.Arrays.equals(r8, r14)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15 = 47
            if (r14 == 0) goto L_0x012d
            r3.read(r13)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r11 = new byte[r9]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r14 = r3.read(r11)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r14 != r9) goto L_0x0125
            byte[] r9 = WEBP_VP8_SIGNATURE     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r9 = java.util.Arrays.equals(r9, r11)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r9 == 0) goto L_0x0125
            int r9 = r3.readInt()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r11 = r9 << 18
            int r11 = r11 >> 18
            int r14 = r9 << 2
            int r14 = r14 >> 18
            int r2 = r2 + -10
            goto L_0x015f
        L_0x0125:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            java.lang.String r2 = "Encountered error while checking VP8 signature"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            throw r0     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        L_0x012d:
            byte[] r9 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r9 = java.util.Arrays.equals(r8, r9)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r9 == 0) goto L_0x015c
            byte r9 = r3.readByte()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r9 != r15) goto L_0x0154
            int r9 = r3.readInt()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r14 = r9 << 18
            int r14 = r14 >> 18
            int r14 = r14 + r11
            int r16 = r9 << 4
            int r16 = r16 >> 18
            int r11 = r16 + 1
            r16 = r9 & 8
            int r2 = r2 + -5
            r18 = r14
            r14 = r11
            r11 = r18
            goto L_0x0161
        L_0x0154:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            java.lang.String r2 = "Encountered error while checking VP8L signature"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            throw r0     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        L_0x015c:
            r9 = 0
            r11 = 0
            r14 = 0
        L_0x015f:
            r16 = 0
        L_0x0161:
            byte[] r15 = WEBP_CHUNK_TYPE_VP8X     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.write(r15)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15 = 10
            r7.writeInt(r15)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r15 = new byte[r15]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte r17 = r15[r12]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r5 = r17 | 8
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r12] = r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte r5 = r15[r12]     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r17 = 4
            int r16 = r16 << 4
            r5 = r5 | r16
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r12] = r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r11 = r11 + -1
            int r14 = r14 + -1
            byte r5 = (byte) r11     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r17] = r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r5 = 5
            int r12 = r11 >> 8
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r5] = r12     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r5 = 6
            int r11 = r11 >> 16
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r5] = r11     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r5 = 7
            byte r11 = (byte) r14     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r5] = r11     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r5 = r14 >> 8
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r10] = r5     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r5 = 9
            int r10 = r14 >> 16
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r15[r5] = r10     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.write(r15)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.write(r8)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.writeInt(r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r0 = WEBP_CHUNK_TYPE_VP8     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r0 == 0) goto L_0x01bf
            r7.write(r13)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r0 = WEBP_VP8_SIGNATURE     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.write(r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.writeInt(r9)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            goto L_0x01cf
        L_0x01bf:
            byte[] r0 = WEBP_CHUNK_TYPE_VP8L     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            boolean r0 = java.util.Arrays.equals(r8, r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            if (r0 == 0) goto L_0x01cf
            r0 = 47
            r7.write(r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r7.writeInt(r9)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        L_0x01cf:
            copy(r3, r7, r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r1.writeExifSegment(r7)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        L_0x01d5:
            copy(r3, r7)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r0 = r6.size()     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r2 = WEBP_SIGNATURE_2     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r2 = r2.length     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            int r0 = r0 + r2
            r4.writeInt(r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            byte[] r0 = WEBP_SIGNATURE_2     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r4.write(r0)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            r6.writeTo(r4)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            closeQuietly(r6)
            return
        L_0x01ef:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            java.lang.String r2 = "Encountered invalid length while parsing WebP chunk type"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
            throw r0     // Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        L_0x01f7:
            r0 = move-exception
            r2 = r6
            goto L_0x0208
        L_0x01fa:
            r0 = move-exception
            r2 = r6
            goto L_0x0200
        L_0x01fd:
            r0 = move-exception
            goto L_0x0208
        L_0x01ff:
            r0 = move-exception
        L_0x0200:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x01fd }
            java.lang.String r4 = "Failed to save WebP file"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x01fd }
            throw r3     // Catch:{ all -> 0x01fd }
        L_0x0208:
            closeQuietly(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveWebpAttributes(java.io.InputStream, java.io.OutputStream):void");
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private void swapBasedOnImageSize(int i2, int i3) throws IOException {
        if (this.mAttributes[i2].isEmpty() || this.mAttributes[i3].isEmpty()) {
            boolean z = DEBUG;
            return;
        }
        ExifAttribute exifAttribute = this.mAttributes[i2].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.mAttributes[i2].get(TAG_IMAGE_WIDTH);
        ExifAttribute exifAttribute3 = this.mAttributes[i3].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute4 = this.mAttributes[i3].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            boolean z2 = DEBUG;
        } else if (exifAttribute3 == null || exifAttribute4 == null) {
            boolean z3 = DEBUG;
        } else {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
            if (intValue < intValue3 && intValue2 < intValue4) {
                HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                HashMap<String, ExifAttribute> hashMap = hashMapArr[i2];
                hashMapArr[i2] = hashMapArr[i3];
                hashMapArr[i3] = hashMap;
            }
        }
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i2].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute4 = this.mAttributes[i2].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i2].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute6 = this.mAttributes[i2].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute7 = this.mAttributes[i2].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr);
                    return;
                }
                exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    "Invalid crop size values. cropSize=" + Arrays.toString(iArr);
                    return;
                }
                exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i2].put(TAG_IMAGE_WIDTH, exifAttribute2);
            this.mAttributes[i2].put(TAG_IMAGE_LENGTH, exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            retrieveJpegImageSize(byteOrderedDataInputStream, i2);
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i2].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[i2].put(TAG_IMAGE_WIDTH, createUShort2);
            }
        }
    }

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        boolean isThumbnail = isThumbnail(this.mAttributes[4]);
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            for (Object obj : this.mAttributes[i2].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0, this.mExifByteOrder));
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong((long) this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            int i4 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.mAttributes[i3].entrySet()) {
                int size = ((ExifAttribute) value.getValue()).size();
                if (size > 4) {
                    i4 += size;
                }
            }
            iArr2[i3] = iArr2[i3] + i4;
        }
        int i5 = 8;
        for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
            if (!this.mAttributes[i6].isEmpty()) {
                iArr[i6] = i5;
                i5 += (this.mAttributes[i6].size() * 12) + 2 + 4 + iArr2[i6];
            }
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong((long) i5, this.mExifByteOrder));
            this.mThumbnailOffset = i5;
            i5 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i5 += 8;
        }
        if (DEBUG) {
            for (int i7 = 0; i7 < EXIF_TAGS.length; i7++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i7), Integer.valueOf(iArr[i7]), Integer.valueOf(this.mAttributes[i7].size()), Integer.valueOf(iArr2[i7]), Integer.valueOf(i5)});
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], this.mExifByteOrder));
        }
        int i8 = this.mMimeType;
        if (i8 == 4) {
            byteOrderedDataOutputStream2.writeUnsignedShort(i5);
            byteOrderedDataOutputStream2.write(IDENTIFIER_EXIF_APP1);
        } else if (i8 == 13) {
            byteOrderedDataOutputStream2.writeInt(i5);
            byteOrderedDataOutputStream2.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i8 == 14) {
            byteOrderedDataOutputStream2.write(WEBP_CHUNK_TYPE_EXIF);
            byteOrderedDataOutputStream2.writeInt(i5);
        }
        byteOrderedDataOutputStream2.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream2.writeUnsignedShort(42);
        byteOrderedDataOutputStream2.writeUnsignedInt(8);
        for (int i9 = 0; i9 < EXIF_TAGS.length; i9++) {
            if (!this.mAttributes[i9].isEmpty()) {
                byteOrderedDataOutputStream2.writeUnsignedShort(this.mAttributes[i9].size());
                int size2 = iArr[i9] + 2 + (this.mAttributes[i9].size() * 12) + 4;
                for (Map.Entry next : this.mAttributes[i9].entrySet()) {
                    int i10 = sExifTagMapsForWriting[i9].get(next.getKey()).number;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int size3 = exifAttribute.size();
                    byteOrderedDataOutputStream2.writeUnsignedShort(i10);
                    byteOrderedDataOutputStream2.writeUnsignedShort(exifAttribute.format);
                    byteOrderedDataOutputStream2.writeInt(exifAttribute.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream2.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream2.write(exifAttribute.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream2.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i9 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream2.writeUnsignedInt(0);
                } else {
                    byteOrderedDataOutputStream2.writeUnsignedInt((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> value2 : this.mAttributes[i9].entrySet()) {
                    byte[] bArr = ((ExifAttribute) value2.getValue()).bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream2.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i5 % 2 == 1) {
            byteOrderedDataOutputStream2.writeByte(0);
        }
        byteOrderedDataOutputStream2.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i5;
    }

    public void flipHorizontally() {
        int i2 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i2 = 2;
                break;
            case 2:
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 8;
                break;
            case 8:
                i2 = 7;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i2));
    }

    public void flipVertically() {
        int i2 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 7;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i2));
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i2 = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        if (attributeInt != 1) {
            i2 = 1;
        }
        return attributeDouble * ((double) i2);
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                if (!sTagSetForCompatibility.contains(str)) {
                    return exifAttribute.getStringValue(this.mExifByteOrder);
                }
                if (str.equals(TAG_GPS_TIMESTAMP)) {
                    int i2 = exifAttribute.format;
                    if (i2 == 5 || i2 == 10) {
                        Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                        if (rationalArr == null || rationalArr.length != 3) {
                            "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr);
                            return null;
                        }
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator)))});
                    }
                    "GPS Timestamp format is not rational. format=" + exifAttribute.format;
                    return null;
                }
                try {
                    return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                return exifAttribute.bytes;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(@NonNull String str, double d) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return d;
            }
            try {
                return exifAttribute.getDoubleValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return d;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int getAttributeInt(@NonNull String str, int i2) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return i2;
            }
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return i2;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        } else if (!this.mModified) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return null;
            }
            return new long[]{exifAttribute.bytesOffset, (long) exifAttribute.bytes.length};
        } else {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @SuppressLint({"AutoBoxing"})
    @Nullable
    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null || (!sNonZeroTimePattern.matcher(attribute).matches() && !sNonZeroTimePattern.matcher(attribute2).matches()))) {
            try {
                Date parse = sFormatter.parse(attribute + Ascii.CASE_MASK + attribute2, new ParsePosition(0));
                if (parse == null) {
                    return null;
                }
                return Long.valueOf(parse.getTime());
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i2 = this.mThumbnailCompression;
        if (i2 == 6 || i2 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i2 = this.mThumbnailCompression;
        if (i2 == 6 || i2 == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i2 == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                byte[] bArr = this.mThumbnailBytes;
                int i4 = i3 * 3;
                iArr[i3] = (bArr[i4] << Ascii.DLE) + 0 + (bArr[i4 + 1] << 8) + bArr[i4 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0061 A[SYNTHETIC, Splitter:B:40:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009f A[Catch:{ Exception -> 0x00b3, all -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00b8  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getThumbnailBytes() {
        /*
            r10 = this;
            boolean r0 = r10.mHasThumbnail
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r0 = r10.mThumbnailBytes
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            android.content.res.AssetManager$AssetInputStream r0 = r10.mAssetInputStream     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            if (r0 == 0) goto L_0x002a
            android.content.res.AssetManager$AssetInputStream r0 = r10.mAssetInputStream     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            boolean r2 = r0.markSupported()     // Catch:{ Exception -> 0x0027, all -> 0x0020 }
            if (r2 == 0) goto L_0x001c
            r0.reset()     // Catch:{ Exception -> 0x0027, all -> 0x0020 }
        L_0x001a:
            r2 = r1
            goto L_0x005f
        L_0x001c:
            closeQuietly(r0)
            return r1
        L_0x0020:
            r2 = move-exception
            r9 = r1
            r1 = r0
            r0 = r2
            r2 = r9
            goto L_0x00a8
        L_0x0027:
            r2 = r1
            goto L_0x00b3
        L_0x002a:
            java.lang.String r0 = r10.mFilename     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            if (r0 == 0) goto L_0x0036
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            java.lang.String r2 = r10.mFilename     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            goto L_0x001a
        L_0x0036:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            r2 = 21
            if (r0 < r2) goto L_0x005d
            java.io.FileDescriptor r0 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            if (r0 == 0) goto L_0x005d
            java.io.FileDescriptor r0 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            java.io.FileDescriptor r0 = android.system.Os.dup(r0)     // Catch:{ Exception -> 0x00b1, all -> 0x00a5 }
            r2 = 0
            int r4 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            android.system.Os.lseek(r0, r2, r4)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            r9 = r2
            r2 = r0
            r0 = r9
            goto L_0x005f
        L_0x0056:
            r2 = move-exception
            r9 = r2
            r2 = r0
            goto L_0x009d
        L_0x005a:
            r2 = r0
            r0 = r1
            goto L_0x00b3
        L_0x005d:
            r0 = r1
            r2 = r0
        L_0x005f:
            if (r0 == 0) goto L_0x009f
            int r3 = r10.mThumbnailOffset     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r4 = r10.mOffsetToExifData     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r3 = r3 + r4
            long r3 = (long) r3     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            long r3 = r0.skip(r3)     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r5 = r10.mThumbnailOffset     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r6 = r10.mOffsetToExifData     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r5 = r5 + r6
            long r5 = (long) r5
            java.lang.String r7 = "Corrupted image"
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0094
            int r3 = r10.mThumbnailLength     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r4 = r0.read(r3)     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            int r5 = r10.mThumbnailLength     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            if (r4 != r5) goto L_0x008e
            r10.mThumbnailBytes = r3     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            closeQuietly(r0)
            if (r2 == 0) goto L_0x008d
            closeFileDescriptor(r2)
        L_0x008d:
            return r3
        L_0x008e:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            throw r3     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
        L_0x0094:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            throw r3     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
        L_0x009a:
            r1 = move-exception
            r9 = r1
            r1 = r0
        L_0x009d:
            r0 = r9
            goto L_0x00a8
        L_0x009f:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            r3.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
            throw r3     // Catch:{ Exception -> 0x00b3, all -> 0x009a }
        L_0x00a5:
            r2 = move-exception
            r0 = r2
            r2 = r1
        L_0x00a8:
            closeQuietly(r1)
            if (r2 == 0) goto L_0x00b0
            closeFileDescriptor(r2)
        L_0x00b0:
            throw r0
        L_0x00b1:
            r0 = r1
            r2 = r0
        L_0x00b3:
            closeQuietly(r0)
            if (r2 == 0) goto L_0x00bb
            closeFileDescriptor(r2)
        L_0x00bb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getThumbnailBytes():byte[]");
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.mHasThumbnail) {
            return null;
        } else {
            if (this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
                return null;
            }
            return new long[]{(long) (this.mThumbnailOffset + this.mOffsetToExifData), (long) this.mThumbnailLength};
        }
    }

    public boolean hasAttribute(@NonNull String str) {
        return getExifAttribute(str) != null;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i2 = this.mThumbnailCompression;
        if (i2 == 6 || i2 == 7) {
            return true;
        }
        return false;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i2) {
        if (i2 % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            int i3 = 0;
            if (ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
                if (indexOf < 0) {
                    i3 = 4;
                }
                i3 = ROTATION_ORDER.get(indexOf + i3).intValue();
            } else if (FLIPPED_ROTATION_ORDER.contains(Integer.valueOf(attributeInt))) {
                int indexOf2 = (FLIPPED_ROTATION_ORDER.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
                if (indexOf2 < 0) {
                    i3 = 4;
                }
                i3 = FLIPPED_ROTATION_ORDER.get(indexOf2 + i3).intValue();
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i3));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0146 A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0161 A[Catch:{ all -> 0x0169 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAttributes() throws java.io.IOException {
        /*
            r10 = this;
            boolean r0 = r10.isSupportedFormatForSavingAttributes()
            if (r0 == 0) goto L_0x0189
            java.io.FileDescriptor r0 = r10.mSeekableFileDescriptor
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r10.mFilename
            if (r0 == 0) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0017:
            r0 = 1
            r10.mModified = r0
            byte[] r0 = r10.getThumbnail()
            r10.mThumbnailBytes = r0
            java.lang.String r0 = r10.mFilename
            r1 = 0
            if (r0 == 0) goto L_0x002d
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r10.mFilename
            r0.<init>(r2)
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            java.lang.String r2 = r10.mFilename     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r3 = 0
            r5 = 21
            if (r2 == 0) goto L_0x008f
            java.lang.String r2 = r0.getParent()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r6 = r0.getName()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r7.<init>()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.util.UUID r8 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r7.append(r8)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r8 = "_"
            r7.append(r8)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r9.<init>()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r9.append(r7)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r9.append(r6)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r8.<init>(r2, r6)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            boolean r2 = r0.renameTo(r8)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            if (r2 == 0) goto L_0x0074
            r2 = r1
            r6 = r2
            goto L_0x00c7
        L_0x0074:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r2.<init>()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r3 = "Couldn't rename to "
            r2.append(r3)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r3 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r2.append(r3)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            throw r0     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
        L_0x008f:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            if (r2 < r5) goto L_0x00c4
            java.io.FileDescriptor r2 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = "temp"
            java.lang.String r6 = "tmp"
            java.io.File r8 = java.io.File.createTempFile(r2, r6)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.io.FileDescriptor r2 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            android.system.Os.lseek(r2, r3, r6)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.io.FileDescriptor r6 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0177, all -> 0x0174 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00bf, all -> 0x00ba }
            r6.<init>(r8)     // Catch:{ Exception -> 0x00bf, all -> 0x00ba }
            copy(r2, r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            goto L_0x00c7
        L_0x00b6:
            r0 = move-exception
            goto L_0x00bc
        L_0x00b8:
            r0 = move-exception
            goto L_0x00c1
        L_0x00ba:
            r0 = move-exception
            r6 = r1
        L_0x00bc:
            r1 = r2
            goto L_0x0182
        L_0x00bf:
            r0 = move-exception
            r6 = r1
        L_0x00c1:
            r1 = r2
            goto L_0x0179
        L_0x00c4:
            r2 = r1
            r6 = r2
            r8 = r6
        L_0x00c7:
            closeQuietly(r2)
            closeQuietly(r6)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.lang.String r6 = r10.mFilename     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            if (r6 == 0) goto L_0x00de
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.lang.String r4 = r10.mFilename     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            goto L_0x00f6
        L_0x00de:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            if (r6 < r5) goto L_0x00f5
            java.io.FileDescriptor r5 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            if (r5 == 0) goto L_0x00f5
            java.io.FileDescriptor r5 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            android.system.Os.lseek(r5, r3, r6)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.io.FileDescriptor r4 = r10.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            goto L_0x00f6
        L_0x00f5:
            r3 = r1
        L_0x00f6:
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0139, all -> 0x0136 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0131, all -> 0x012d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0131, all -> 0x012d }
            int r3 = r10.mMimeType     // Catch:{ Exception -> 0x012a, all -> 0x0128 }
            r5 = 4
            if (r3 != r5) goto L_0x0109
            r10.saveJpegAttributes(r4, r2)     // Catch:{ Exception -> 0x012a, all -> 0x0128 }
            goto L_0x011c
        L_0x0109:
            int r3 = r10.mMimeType     // Catch:{ Exception -> 0x012a, all -> 0x0128 }
            r5 = 13
            if (r3 != r5) goto L_0x0113
            r10.savePngAttributes(r4, r2)     // Catch:{ Exception -> 0x012a, all -> 0x0128 }
            goto L_0x011c
        L_0x0113:
            int r3 = r10.mMimeType     // Catch:{ Exception -> 0x012a, all -> 0x0128 }
            r5 = 14
            if (r3 != r5) goto L_0x011c
            r10.saveWebpAttributes(r4, r2)     // Catch:{ Exception -> 0x012a, all -> 0x0128 }
        L_0x011c:
            closeQuietly(r4)
            closeQuietly(r2)
            r8.delete()
            r10.mThumbnailBytes = r1
            return
        L_0x0128:
            r0 = move-exception
            goto L_0x012f
        L_0x012a:
            r1 = move-exception
            r3 = r1
            goto L_0x0134
        L_0x012d:
            r0 = move-exception
            r2 = r1
        L_0x012f:
            r1 = r4
            goto L_0x016a
        L_0x0131:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0134:
            r1 = r4
            goto L_0x013c
        L_0x0136:
            r0 = move-exception
            r2 = r1
            goto L_0x016a
        L_0x0139:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x013c:
            java.lang.String r4 = r10.mFilename     // Catch:{ all -> 0x0169 }
            if (r4 == 0) goto L_0x0161
            boolean r4 = r8.renameTo(r0)     // Catch:{ all -> 0x0169 }
            if (r4 != 0) goto L_0x0161
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0169 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            r4.<init>()     // Catch:{ all -> 0x0169 }
            java.lang.String r5 = "Couldn't restore original file: "
            r4.append(r5)     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0169 }
            r4.append(r0)     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0169 }
            r3.<init>(r0)     // Catch:{ all -> 0x0169 }
            throw r3     // Catch:{ all -> 0x0169 }
        L_0x0161:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0169 }
            java.lang.String r4 = "Failed to save new file"
            r0.<init>(r4, r3)     // Catch:{ all -> 0x0169 }
            throw r0     // Catch:{ all -> 0x0169 }
        L_0x0169:
            r0 = move-exception
        L_0x016a:
            closeQuietly(r1)
            closeQuietly(r2)
            r8.delete()
            throw r0
        L_0x0174:
            r0 = move-exception
            r6 = r1
            goto L_0x0182
        L_0x0177:
            r0 = move-exception
            r6 = r1
        L_0x0179:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0181 }
            throw r2     // Catch:{ all -> 0x0181 }
        L_0x0181:
            r0 = move-exception
        L_0x0182:
            closeQuietly(r1)
            closeQuietly(r6)
            throw r0
        L_0x0189:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveAttributes():void");
    }

    public void setAltitude(double d) {
        String str = d >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setAttribute(@NonNull String str, @Nullable String str2) {
        ExifTag exifTag;
        int i2;
        String str3;
        String str4 = str;
        String str5 = str2;
        if (str4 != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str4)) {
                boolean z = DEBUG;
                str4 = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            int i3 = 2;
            int i4 = 1;
            if (str5 != null && sTagSetForCompatibility.contains(str4)) {
                if (str4.equals(TAG_GPS_TIMESTAMP)) {
                    Matcher matcher = sGpsTimestampPattern.matcher(str5);
                    if (!matcher.find()) {
                        "Invalid value for " + str4 + " : " + str5;
                        return;
                    }
                    str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str5 = new Rational(Double.parseDouble(str2)).toString();
                    } catch (NumberFormatException unused) {
                        "Invalid value for " + str4 + " : " + str5;
                        return;
                    }
                }
            }
            int i5 = 0;
            while (i5 < EXIF_TAGS.length) {
                if ((i5 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i5].get(str4)) != null) {
                    if (str5 != null) {
                        Pair<Integer, Integer> guessDataFormat = guessDataFormat(str5);
                        if (exifTag.primaryFormat == ((Integer) guessDataFormat.first).intValue() || exifTag.primaryFormat == ((Integer) guessDataFormat.second).intValue()) {
                            i2 = exifTag.primaryFormat;
                        } else {
                            int i6 = exifTag.secondaryFormat;
                            if (i6 == -1 || !(i6 == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                                int i7 = exifTag.primaryFormat;
                                if (i7 == i4 || i7 == 7 || i7 == i3) {
                                    i2 = exifTag.primaryFormat;
                                } else if (DEBUG) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Given tag (");
                                    sb.append(str4);
                                    sb.append(") value didn't match with one of expected formats: ");
                                    sb.append(IFD_FORMAT_NAMES[exifTag.primaryFormat]);
                                    String str6 = "";
                                    if (exifTag.secondaryFormat == -1) {
                                        str3 = str6;
                                    } else {
                                        str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + IFD_FORMAT_NAMES[exifTag.secondaryFormat];
                                    }
                                    sb.append(str3);
                                    sb.append(" (guess: ");
                                    sb.append(IFD_FORMAT_NAMES[((Integer) guessDataFormat.first).intValue()]);
                                    if (((Integer) guessDataFormat.second).intValue() != -1) {
                                        str6 = StringUtil.ARRAY_ELEMENT_SEPARATOR + IFD_FORMAT_NAMES[((Integer) guessDataFormat.second).intValue()];
                                    }
                                    sb.append(str6);
                                    sb.append(")");
                                    sb.toString();
                                }
                            } else {
                                i2 = exifTag.secondaryFormat;
                            }
                        }
                        switch (i2) {
                            case 1:
                                this.mAttributes[i5].put(str4, ExifAttribute.createByte(str5));
                                break;
                            case 2:
                            case 7:
                                this.mAttributes[i5].put(str4, ExifAttribute.createString(str5));
                                break;
                            case 3:
                                String[] split = str5.split(",", -1);
                                int[] iArr = new int[split.length];
                                for (int i8 = 0; i8 < split.length; i8++) {
                                    iArr[i8] = Integer.parseInt(split[i8]);
                                }
                                this.mAttributes[i5].put(str4, ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                                break;
                            case 4:
                                String[] split2 = str5.split(",", -1);
                                long[] jArr = new long[split2.length];
                                for (int i9 = 0; i9 < split2.length; i9++) {
                                    jArr[i9] = Long.parseLong(split2[i9]);
                                }
                                this.mAttributes[i5].put(str4, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                break;
                            case 5:
                                String[] split3 = str5.split(",", -1);
                                Rational[] rationalArr = new Rational[split3.length];
                                for (int i10 = 0; i10 < split3.length; i10++) {
                                    String[] split4 = split3[i10].split("/", -1);
                                    rationalArr[i10] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                }
                                this.mAttributes[i5].put(str4, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                break;
                            case 9:
                                String[] split5 = str5.split(",", -1);
                                int[] iArr2 = new int[split5.length];
                                for (int i11 = 0; i11 < split5.length; i11++) {
                                    iArr2[i11] = Integer.parseInt(split5[i11]);
                                }
                                this.mAttributes[i5].put(str4, ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                                break;
                            case 10:
                                String[] split6 = str5.split(",", -1);
                                Rational[] rationalArr2 = new Rational[split6.length];
                                int i12 = 0;
                                while (i12 < split6.length) {
                                    String[] split7 = split6[i12].split("/", -1);
                                    rationalArr2[i12] = new Rational((long) Double.parseDouble(split7[0]), (long) Double.parseDouble(split7[i4]));
                                    i12++;
                                    i4 = 1;
                                }
                                this.mAttributes[i5].put(str4, ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                                break;
                            case 12:
                                String[] split8 = str5.split(",", -1);
                                double[] dArr = new double[split8.length];
                                for (int i13 = 0; i13 < split8.length; i13++) {
                                    dArr[i13] = Double.parseDouble(split8[i13]);
                                }
                                this.mAttributes[i5].put(str4, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                                break;
                            default:
                                if (!DEBUG) {
                                    break;
                                } else {
                                    "Data format isn't one of expected formats: " + i2;
                                    break;
                                }
                        }
                    } else {
                        this.mAttributes[i5].remove(str4);
                    }
                }
                i5++;
                i3 = 2;
                i4 = 1;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(@NonNull Long l) {
        setAttribute(TAG_DATETIME, sFormatter.format(new Date(l.longValue())));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(l.longValue() % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatter.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
        } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        } else {
            setAttribute(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : LATITUDE_SOUTH);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d)));
            setAttribute(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d2)));
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        byte[] bArr = new byte[8192];
        while (i2 > 0) {
            int min = Math.min(i2, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i2 -= read;
                outputStream.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4});
            return null;
        }
    }

    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String str, int i2, int i3) {
            this.name = str;
            this.number = i2;
            this.primaryFormat = i3;
            this.secondaryFormat = -1;
        }

        public boolean isFormatCompatible(int i2) {
            int i3;
            int i4 = this.primaryFormat;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.secondaryFormat) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((this.primaryFormat == 9 || this.secondaryFormat == 9) && i2 == 8) {
                return true;
            }
            if ((this.primaryFormat == 12 || this.secondaryFormat == 12) && i2 == 11) {
                return true;
            }
            return false;
        }

        public ExifTag(String str, int i2, int i3, int i4) {
            this.name = str;
            this.number = i2;
            this.primaryFormat = i3;
            this.secondaryFormat = i4;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor r6) throws java.io.IOException {
        /*
            r5 = this;
            r5.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = EXIF_TAGS
            int r0 = r0.length
            java.util.HashMap[] r0 = new java.util.HashMap[r0]
            r5.mAttributes = r0
            java.util.HashSet r0 = new java.util.HashSet
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r1 = EXIF_TAGS
            int r1 = r1.length
            r0.<init>(r1)
            r5.mAttributesOffsets = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r5.mExifByteOrder = r0
            if (r6 == 0) goto L_0x005f
            r0 = 0
            r5.mAssetInputStream = r0
            r5.mFilename = r0
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x003d
            boolean r2 = isSeekableFD(r6)
            if (r2 == 0) goto L_0x003d
            r5.mSeekableFileDescriptor = r6
            java.io.FileDescriptor r6 = android.system.Os.dup(r6)     // Catch:{ Exception -> 0x0034 }
            r1 = 1
            goto L_0x003f
        L_0x0034:
            r6 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r6)
            throw r0
        L_0x003d:
            r5.mSeekableFileDescriptor = r0
        L_0x003f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0052 }
            r2.<init>(r6)     // Catch:{ all -> 0x0052 }
            r5.loadAttributes(r2)     // Catch:{ all -> 0x0050 }
            closeQuietly(r2)
            if (r1 == 0) goto L_0x004f
            closeFileDescriptor(r6)
        L_0x004f:
            return
        L_0x0050:
            r0 = move-exception
            goto L_0x0056
        L_0x0052:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x0056:
            closeQuietly(r2)
            if (r1 == 0) goto L_0x005e
            closeFileDescriptor(r6)
        L_0x005e:
            throw r0
        L_0x005f:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "fileDescriptor cannot be null"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i2) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i2 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                if (isExifDataOnly(bufferedInputStream)) {
                    this.mIsExifDataOnly = true;
                    this.mAssetInputStream = null;
                    this.mSeekableFileDescriptor = null;
                    inputStream = bufferedInputStream;
                } else {
                    return;
                }
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
