package com.wd.utils.document;

import com.wd.data.document.QiNiuResponseInfo;
import com.wd.utils.JSONUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;

/**
 * Created by Zhipeng on 2016/6/6.
 */
public class QiNiuUtil {
    public static final String suffix = "_商业计划书";
    //设置好账号的ACCESS_KEY和SECRET_KEY
    public static final String ACCESS_KEY = "ATy7CWhN9_Tj2vNt65ZkA-waP7ELE_D9oozjUrSe";
    public static final String SECRET_KEY = "WHm_JTt07az6NMoJJmJrUBp57OXoTwhgcoDUuNXQ";
    //要上传的空间
    public static final String bucketname = "alibaodutech";

    public static final String URL = "http://o8dpkkbv5.bkt.clouddn.com/";

    //密钥配置
    public static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //实例化一个BucketManager对象
    public static BucketManager bucketManager = new BucketManager(auth);
    //创建上传对象
    public static final UploadManager uploadManager = new UploadManager();

    public static String getFileName(Long userId, String fileSuffix) {
        return userId.toString() + suffix + fileSuffix;
    }

    public static String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public static String uploadFile(String filePath, Long userId, String fileSuffix) throws QiniuException {
        //调用put方法上传
        Response res = uploadManager.put(filePath, getFileName(userId, fileSuffix), getUpToken());
        QiNiuResponseInfo qiNiuResponseInfo = getResponseInfo(res.bodyString());
        if (qiNiuResponseInfo == null)
            return null;
        else {
            if (!(StringUtils.isNullOrEmpty(qiNiuResponseInfo.getKey()))) {
                return qiNiuResponseInfo.getKey();
            } else {
                return null;
            }
        }
    }

    public static QiNiuResponseInfo getResponseInfo(String json) {
        QiNiuResponseInfo qiNiuResponseInfo = null;
        try {
            qiNiuResponseInfo = JSONUtil.JSONStringToObject(json, QiNiuResponseInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qiNiuResponseInfo;
    }

    public static String privateDownload(Long userId, String suffix) {
        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
       return privateDownload(getFileName(userId, suffix));

    }

    public static String privateDownload(String fileName) {
        String downloadRUL = auth.privateDownloadUrl(URL + fileName, 600);
        return downloadRUL;
    }

    public static boolean deletePrevious(Long userId, String suffix) {
        return deletePrevious(getFileName(userId, suffix));
    }

    public static boolean deletePrevious(String fileName) {
        try {
            bucketManager.delete(bucketname, fileName);
            return true;
        } catch (QiniuException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getFileSuffix(String fileName) throws Exception {
        String ext = null;
        int inx = fileName.lastIndexOf(".");
        if (inx > 0)
            ext = fileName.substring(inx + 1);
        else
            throw new Exception("文件没有扩展名");
        return ext;
    }
//
}
