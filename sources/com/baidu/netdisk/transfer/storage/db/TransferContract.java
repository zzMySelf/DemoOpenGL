package com.baidu.netdisk.transfer.storage.db;

import android.net.Uri;
import android.provider.BaseColumns;
import com.baidu.netdisk.base.storage.db.BaseContract;
import com.baidu.netdisk.cloudfile.storage.db.CloudFileContract;
import com.baidu.netdisk.transfer.storage.db.upload.UploadTaskProviderInfo;
import com.baidu.searchbox.downloads.DownloadConstants;

public class TransferContract implements BaseContract {
    public static final Uri BASE_CONTENT_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + CONTENT_AUTHORITY + "/transfer");

    interface DownloadSmoothVideoTasksColumns {
        public static final String DURING = "during";
        public static final String FROM_UK = "from_uk";
        public static final String GROUP_ID_CONVERSATION_UK = "group_id_conversation_uk";
        public static final String LOCAL_URL = "local_url";
        public static final String MESSAGE_ID = "message_id";
        public static final String MESSAGE_TYPE = "message_type";
        public static final String OLD_LOCAL_PATH = "old_local_path";
        public static final String ORIGIN_PATH = "origin_path";
        public static final String ORIGIN_SIZE = "origin_size";
        public static final String PCS_PATH = "pcs_path";
        public static final String SHARE_FID = "share_fid";
        public static final String SHARE_ID = "share_id";
        public static final String SHARE_PATH = "share_path";
        public static final String SHARE_UK = "share_uk";
        public static final String TASK_ID = "task_id";
        public static final String VIDEO_TYPE = "video_type";
    }

    protected interface DownloadTaskFilesColumns {
        public static final String LOCAL_LAST_MODIFY_TIME = "local_last_modify_time";
        public static final String LOCAL_MD5 = "file_true_md5";
        public static final String LOCAL_PATH = "local_path";
        public static final String SERVER_PATH = "server_path";
    }

    public interface TasksColumns {
        public static final String DATE = "date";
        public static final String EXTRA_INFO = "extra_info";
        public static final String EXTRA_INFO_DO_SUCCESS = "extra_info_do_success";
        public static final String EXTRA_INFO_NUM = "extra_info_num";
        public static final String IS_DOWNLOAD_SDK_TASK = "is_download_sdk_task";
        public static final String IS_P2P_FAILED = "is_p2p_failed";
        public static final String IS_P2P_TASK = "is_p2p_task";
        public static final String LOCAL_URL = "local_url";
        public static final String OFFSET_SIZE = "offset_size";
        public static final String P2P_FGID = "p2p_fgid";
        public static final String PRIORITY = "priority";
        public static final String RATE = "rate";
        public static final String REMOTE_URL = "remote_url";
        public static final String SIZE = "size";
        public static final String STATE = "state";
        public static final String TRANSMITTER_TYPE = "transmitter_type";
        public static final String TYPE = "type";
    }

    public static class Tasks implements TasksColumns, BaseColumns {
        public static final int EXTRA_INFO_NUM_DEFAULT = 0;
        public static final int EXTRA_INFO_NUM_FILE_NOT_EXIST = 1;
        public static final String IS_DELETE_FILE = "is_delete_file";
        public static final int NO = 0;
        public static final int STATE_BACKUP = 200;
        public static final int STATE_BACKUP_FAIL = 203;
        public static final int STATE_BACKUP_PAUSE = 202;
        public static final int STATE_BACKUP_RUNNING = 201;
        public static final int STATE_BACKUP_SUCCESS = 204;
        public static final int STATE_DELETED = 10;
        public static final int STATE_FAILED = 106;
        public static final int STATE_FINISHED = 110;
        public static final int STATE_NULL = -100;
        public static final int STATE_PAUSE = 105;
        public static final int STATE_PENDING = 100;
        public static final int STATE_PROCESSING = 109;
        public static final int STATE_RUNNING = 104;
        public static final int STATE_WAITING_FOR_WIFI = 11;
        public static final String TRANSMITTER_PLATFORM_PLUGIN_LINK = "6";
        public static final String TRANSMITTER_TYPE_CLOUDP2P_DLINK = "4";
        public static final String TRANSMITTER_TYPE_DLINK = "2";
        public static final String TRANSMITTER_TYPE_LINK = "5";
        public static final String TRANSMITTER_TYPE_M3U8 = "3";
        public static final String TRANSMITTER_TYPE_PCS = "1";
        public static final String TRANSMITTER_TYPE_PMALL_NOVEL_DLINK = "7";
        public static final String TRANSMITTER_TYPE_WEB = "0";
        public static final int YES = 1;

        public interface CommonQuery {
            public static final int ID = 0;
            public static final int LOCAL_URL = 1;
            public static final String[] PROJECTION = {"_id", "local_url", TasksColumns.REMOTE_URL, "size"};
            public static final int REMOTE_URL = 2;
            public static final int SIZE = 3;
        }

        public static boolean getDeleteFile(Uri uri) {
            return String.valueOf(1).equals(uri.getQueryParameter(IS_DELETE_FILE));
        }
    }

    public static class UploadTasks extends Tasks {
        public static final Uri BASE_CONTENT_URI;
        public static final String CATEGORY = "category";
        public static final int EXTRA_FILE_IS_IMPERFECT = 6;
        public static final int EXTRA_FILE_MORE_NUMBER = 10;
        public static final int EXTRA_FILE_NAME_ILLEGAL = 8;
        public static final int EXTRA_FILE_PARAMETER_ERROR = 9;
        public static final int EXTRA_FILE_SIZE_LIMIT = 11;
        public static final int EXTRA_INFO_NUM_FILE_OUT_OF_AUTHORIZATION = 5;
        public static final int EXTRA_INFO_NUM_NO_REMOTE_SPACE = 2;
        public static final int EXTRA_INFO_NUM_UPLOAD_BY_OTHER_APP = 4;
        public static final int EXTRA_INFO_SERVER_BAN = 7;
        public static final Uri FAILED_CONTENT_URI;
        public static final Uri FINISHED_CONTENT_URI;
        public static final String FS_ID = "fs_id";
        public static final String IS_DIR = "is_dir";
        public static final String NEED_OVERRIDE = "need_override";
        public static final Uri PROCESSING_CONTENT_URI;
        public static final String QUALITY = "quality";
        public static final int SAFE_BOX_SIZE_LIMIT = 12;
        public static final Uri SCHEDULER_CONTENT_URI;
        public static final String TRANSMITTER_TYPE_UPLOAD = "upload";
        public static final int TYPE_UPLOAD_FILE = 0;
        public static final int TYPE_UPLOAD_PHOTO = 2;
        public static final int TYPE_UPLOAD_VIDEO = 3;
        public static final String UPLOAD_ID = "upload_id";
        public static final int UPLOAD_OVERRIDE = 0;
        public static final int UPLOAD_RENAME = 1;

        public interface FailedQuery {
            public static final int CATEGORY = 9;
            public static final int EXTRA_INFO_NUM = 2;
            public static final int FS_ID = 7;
            public static final int ID = 0;
            public static final int IS_DIR = 8;
            public static final int LOCAL_URL = 1;
            public static final String[] PROJECTION = {"_id", "local_url", TasksColumns.EXTRA_INFO_NUM, "type", "quality", UploadTasks.UPLOAD_ID, TasksColumns.REMOTE_URL, "fs_id", UploadTasks.IS_DIR, "category"};
            public static final int QUALITY = 4;
            public static final int REMOTE_URL = 6;
            public static final int TYPE = 3;
            public static final int UPLOAD_ID = 5;
        }

        public interface FinishedQuery {
            public static final int CATEGORY = 7;
            public static final int DATE = 3;
            public static final int FS_ID = 5;
            public static final int ID = 0;
            public static final int IS_DIR = 6;
            public static final int LOCAL_URL = 1;
            public static final String[] PROJECTION = {"_id", "local_url", "size", "date", TasksColumns.REMOTE_URL, "fs_id", UploadTasks.IS_DIR, "category"};
            public static final int REMOTE_URL = 4;
            public static final int SIZE = 2;
        }

        public interface ProcessingQuery {
            public static final int CATEGORY = 11;
            public static final int FS_ID = 9;
            public static final int ID = 0;
            public static final int IS_DIR = 10;
            public static final int LOCAL_URL = 1;
            public static final int OFFSET_SIZE = 2;
            public static final int PRIORITY = 6;
            public static final String[] PROJECTION = {"_id", "local_url", TasksColumns.OFFSET_SIZE, "size", "state", "rate", "priority", "quality", UploadTasks.UPLOAD_ID, "fs_id", UploadTasks.IS_DIR, "category"};
            public static final int QUALITY = 7;
            public static final int RATE = 5;
            public static final int SIZE = 3;
            public static final int STATE = 4;
            public static final int UPLOAD_ID = 8;
        }

        static {
            Uri build = TransferContract.BASE_CONTENT_URI.buildUpon().appendPath(UploadTaskProviderInfo.PATH_UPLOAD_TASK).build();
            BASE_CONTENT_URI = build;
            PROCESSING_CONTENT_URI = build.buildUpon().appendPath("processing").build();
            FINISHED_CONTENT_URI = build.buildUpon().appendPath("finished").build();
            FAILED_CONTENT_URI = build.buildUpon().appendPath("failed").build();
            SCHEDULER_CONTENT_URI = build.buildUpon().appendPath("scheduler").build();
        }

        public static Uri buildUri(String bduss) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }

        public static Uri buildDeleteUri(String bduss, boolean isDeleteFile) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).appendQueryParameter(Tasks.IS_DELETE_FILE, String.valueOf(isDeleteFile ? 1 : 0)).build();
        }

        public static Uri buildProcessingUri(String bduss) {
            return buildProcessingUri(bduss, true);
        }

        public static Uri buildProcessingUri(String bduss, boolean isNotify) {
            return PROCESSING_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).appendQueryParameter(BaseContract.QUERY_PARAMETER_IS_NOTIFY, String.valueOf(isNotify)).build();
        }

        public static Uri buildSchedulerUri(String bduss) {
            return SCHEDULER_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }

        public static Uri buildFinishedUri(String bduss, boolean isNotify) {
            return FINISHED_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).appendQueryParameter(BaseContract.QUERY_PARAMETER_IS_NOTIFY, String.valueOf(isNotify)).build();
        }

        public static Uri buildFailedUri(String bduss) {
            return FAILED_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }

    public static class DeletedUploadTasks {
        public static final Uri BASE_CONTENT_URI = UploadTasks.BASE_CONTENT_URI.buildUpon().appendPath("deleted").build();

        public static Uri buildUri(String bduss) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }

    public static class AlbumBackupTasks extends UploadTasks {
        public static final Uri BASE_CONTENT_URI = UploadTasks.BASE_CONTENT_URI.buildUpon().appendPath("album").build();

        public static Uri buildUri(String bduss) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }

    public static class DownloadTasks extends Tasks {
        public static final Uri BASE_CONTENT_URI;
        public static final int EXTRA_CHEAT_USER = 12;
        public static final int EXTRA_DLINK_REFRESH_FAIL = 13;
        public static final int EXTRA_FILE_HAS_CHANGE = 7;
        public static final int EXTRA_FILE_IS_ILLEGAL = 6;
        public static final int EXTRA_FILE_IS_IMPERFECT = 8;
        public static final int EXTRA_GATEWAY_PASSPORT_ERROR = 47;
        public static final int EXTRA_GATEWAY_RAND_PARAM_ERROR = 48;
        public static final int EXTRA_INFO_NUM_CANCEL_SHARE = 4;
        public static final int EXTRA_INFO_NUM_NO_SDCARD_SPACE = 3;
        public static final int EXTRA_INFO_NUM_WAITING_FOR_SERVER = 5;
        public static final int EXTRA_LOCAL_FILE_SYSTEM_ERROR = 16;
        public static final int EXTRA_LOCAL_RENAME_FAIL = 15;
        public static final int EXTRA_M3U8_TRANSFER_FAIL = 10;
        public static final int EXTRA_P2P_CHECKSUM_ERROR = 17;
        public static final int EXTRA_PCS_FORMAT_NOT_SUPPORT = 28;
        public static final int EXTRA_PCS_HIT_CONCURRENT_TOO_MANY = 46;
        public static final int EXTRA_PCS_OPERATE_NOT_ALLOWED = 26;
        public static final int EXTRA_PCS_PARAM_ERROR = 27;
        public static final int EXTRA_PCS_SIGN_ERROR = 29;
        public static final int EXTRA_SHARE_FILE_NO_DLINK_INFO = 49;
        public static final int EXTRA_STREAMING_API_ADVERTISMENT = 32;
        public static final int EXTRA_STREAMING_API_PARAM_ERROR = 30;
        public static final int EXTRA_STREAMING_API_SAFEBOX_STOKEN_INVALID = 31;
        public static final int EXTRA_STREAMING_CODE_RATE_NOT_SUPPORT = 23;
        public static final int EXTRA_STREAMING_CONVERT_FAILED = 19;
        public static final int EXTRA_STREAMING_DURATION_TOO_LONG = 20;
        public static final int EXTRA_STREAMING_FILE_NOT_EXIST = 36;
        public static final int EXTRA_STREAMING_FILE_NOT_VIDEO = 24;
        public static final int EXTRA_STREAMING_MBOX_GROUP_NOT_EXIST = 39;
        public static final int EXTRA_STREAMING_MBOX_SHARE_NOT_EXIST = 41;
        public static final int EXTRA_STREAMING_MBOX_SHARE_USER_NO_PERMISSION = 42;
        public static final int EXTRA_STREAMING_MBOX_USER_NOT_IN_GROUP = 40;
        public static final int EXTRA_STREAMING_NO_FSID = 35;
        public static final int EXTRA_STREAMING_OTHER_ERROR = 25;
        public static final int EXTRA_STREAMING_PCS_FREQUENCY_ERROR = 43;
        public static final int EXTRA_STREAMING_PCS_RETURN_406 = 38;
        public static final int EXTRA_STREAMING_PLAY_NO_AUTHORITY = 33;
        public static final int EXTRA_STREAMING_QUERY_ERROR_DATA = 45;
        public static final int EXTRA_STREAMING_QUERY_TIMEOUT = 44;
        public static final int EXTRA_STREAMING_SERVER_INTERNAL_ERROR = 34;
        public static final int EXTRA_STREAMING_TS_CLEAN_UP = 21;
        public static final int EXTRA_STREAMING_USER_NO_PERMISSION = 37;
        public static final int EXTRA_STREAMING_VIDEO_NOT_SUPPORT = 22;
        public static final int EXTRA_STREAM_EXCEPTION = 11;
        public static final int EXTRA_TASK_ERR_FILE = 50;
        public static final int EXTRA_TASK_ERR_OPEN_FAILED = 51;
        public static final int EXTRA_TASK_NOT_EXIST_FAIL = 14;
        public static final int EXTRA_USER_AUTH_ERROR = 18;
        public static final int EXTRA_USER_IS_FORBIDDEN = 9;
        public static final Uri FAILED_CONTENT_URI;
        public static final Uri FINISHED_CONTENT_URI;
        public static final Uri PROCESSING_CONTENT_URI;
        public static final Uri SCHEDULER_CONTENT_URI;
        public static final int TYPE_DOWNLOAD_FILE = 1;

        public interface FailedQuery {
            public static final int EXTRA_INFO = 5;
            public static final int EXTRA_INFO_NUM = 3;
            public static final int ID = 0;
            public static final int LOCAL_URL = 1;
            public static final String[] PROJECTION = {"_id", "local_url", TasksColumns.TRANSMITTER_TYPE, TasksColumns.EXTRA_INFO_NUM, TasksColumns.REMOTE_URL, "extra_info"};
            public static final int REMOTE_URL = 4;
            public static final int TRANSMITTER_TYPE = 2;
        }

        public interface FinishedQuery {
            public static final int DATE = 4;
            public static final int ID = 0;
            public static final int LOCAL_URL = 1;
            public static final String[] PROJECTION = {"_id", "local_url", TasksColumns.TRANSMITTER_TYPE, "size", "date", TasksColumns.REMOTE_URL};
            public static final int REMOTE_URL = 5;
            public static final int SIZE = 3;
            public static final int TRANSMITTER_TYPE = 2;
        }

        public interface ProcessingQuery {
            public static final int EXTRA_INFO_NUM = 8;
            public static final int ID = 0;
            public static final int IS_P2P_TASK = 9;
            public static final int LOCAL_URL = 1;
            public static final int OFFSET_SIZE = 4;
            public static final String[] PROJECTION = {"_id", "local_url", TasksColumns.REMOTE_URL, TasksColumns.TRANSMITTER_TYPE, TasksColumns.OFFSET_SIZE, "size", "state", "rate", TasksColumns.EXTRA_INFO_NUM, TasksColumns.IS_P2P_TASK, TasksColumns.IS_DOWNLOAD_SDK_TASK};
            public static final int RATE = 7;
            public static final int REMOTE_URL = 2;
            public static final int SIZE = 5;
            public static final int STATE = 6;
            public static final int TRANSMITTER_TYPE = 3;
        }

        public interface Query {
            public static final int DATE = 7;
            public static final int EXTRA_INFO_NUM = 8;
            public static final int ID = 0;
            public static final int IS_VISIBLE = 10;
            public static final int LOCAL_URL = 2;
            public static final int OFFSET_SIZE = 6;
            public static final int PRIORITY = 9;
            public static final String[] PROJECTION = {"_id", "type", "local_url", TasksColumns.REMOTE_URL, "size", "state", TasksColumns.OFFSET_SIZE, "date", TasksColumns.EXTRA_INFO_NUM, "priority", TasksColumns.TRANSMITTER_TYPE, "rate", CloudFileContract.FilesColumns.FILE_SERVER_MD5};
            public static final int RATE = 12;
            public static final int REMOTE_URL = 3;
            public static final int SERVER_MD5 = 13;
            public static final int SIZE = 4;
            public static final int STATE = 5;
            public static final int TRANSMITTER_TYPE = 11;
            public static final int TYPE = 1;
        }

        static {
            Uri build = TransferContract.BASE_CONTENT_URI.buildUpon().appendPath("downloadtasks").build();
            BASE_CONTENT_URI = build;
            PROCESSING_CONTENT_URI = build.buildUpon().appendPath("processing").build();
            FINISHED_CONTENT_URI = build.buildUpon().appendPath("finished").build();
            FAILED_CONTENT_URI = build.buildUpon().appendPath("failed").build();
            SCHEDULER_CONTENT_URI = build.buildUpon().appendPath("scheduler").build();
        }

        public static Uri buildUri(String bduss) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }

        public static Uri buildDeleteUri(String bduss, boolean isDeleteFile) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).appendQueryParameter(Tasks.IS_DELETE_FILE, String.valueOf(isDeleteFile ? 1 : 0)).build();
        }

        public static Uri buildProcessingUri(String bduss) {
            return buildProcessingUri(bduss, true);
        }

        public static Uri buildProcessingUri(String bduss, boolean isNotify) {
            return PROCESSING_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).appendQueryParameter(BaseContract.QUERY_PARAMETER_IS_NOTIFY, String.valueOf(isNotify)).build();
        }

        public static Uri buildSchedulerUri(String bduss) {
            return SCHEDULER_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }

        public static Uri buildFinishedUri(String bduss, boolean isNotify) {
            return FINISHED_CONTENT_URI.buildUpon().appendQueryParameter(BaseContract.QUERY_PARAMETER_IS_NOTIFY, String.valueOf(isNotify)).appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }

        public static Uri buildFailedUri(String bduss) {
            return FAILED_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }

    public static class DeletedDownloadTasks {
        public static final Uri BASE_CONTENT_URI = DownloadTasks.BASE_CONTENT_URI.buildUpon().appendPath("deleted").build();

        public static Uri buildUri(String bduss) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }

    public static class DownloadSmoothVideoTasks implements DownloadSmoothVideoTasksColumns {
        public static final Uri BASE_CONTENT_URI = DownloadTasks.BASE_CONTENT_URI.buildUpon().appendPath("smoothvideo").build();
        public static final int VIDEO_TYPE_ALBUMLIST = 3;
        public static final int VIDEO_TYPE_CLOUDP2P = 4;
        public static final int VIDEO_TYPE_DEFAULT = 0;
        public static final int VIDEO_TYPE_PCS = 2;
        public static final int VIDEO_TYPE_SHARE = 1;

        public interface Query {
            public static final int DURING = 5;
            public static final int FROM_UK = 11;
            public static final int GROUP_ID_CONVERSATION_UK = 13;
            public static final int LOCAL_PATH = 10;
            public static final int MESSAGE_ID = 12;
            public static final int OLD_LOCAL_PATH = 1;
            public static final int ORIGIN_PATH = 3;
            public static final int ORIGIN_SIZE = 4;
            public static final int PCS_PATH = 2;
            public static final String[] PROJECTION = {"video_type", DownloadSmoothVideoTasksColumns.OLD_LOCAL_PATH, DownloadSmoothVideoTasksColumns.PCS_PATH, DownloadSmoothVideoTasksColumns.ORIGIN_PATH, DownloadSmoothVideoTasksColumns.ORIGIN_SIZE, DownloadSmoothVideoTasksColumns.DURING, DownloadSmoothVideoTasksColumns.SHARE_PATH, DownloadSmoothVideoTasksColumns.SHARE_ID, DownloadSmoothVideoTasksColumns.SHARE_UK, DownloadSmoothVideoTasksColumns.SHARE_FID, "local_url", "from_uk", "message_id", DownloadSmoothVideoTasksColumns.GROUP_ID_CONVERSATION_UK, "message_type"};
            public static final int SHARE_FID = 9;
            public static final int SHARE_ID = 7;
            public static final int SHARE_PATH = 6;
            public static final int SHARE_UK = 8;
            public static final int TYPE = 14;
            public static final int VIDEO_TYPE = 0;
        }

        public static Uri buildUri(String bduss) {
            return BASE_CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }

    public static class DownloadTaskFiles implements DownloadTaskFilesColumns, BaseColumns {
        private static final Uri CONTENT_URI = DownloadTasks.BASE_CONTENT_URI.buildUpon().appendPath("finished").appendPath("files").build();

        public interface Query {
            public static final String[] PROJECTION = {"_id", "server_path", "local_path", DownloadTaskFilesColumns.LOCAL_MD5, DownloadTaskFilesColumns.LOCAL_LAST_MODIFY_TIME};
        }

        public static Uri buildUri(String bduss) {
            return CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
        }
    }
}
