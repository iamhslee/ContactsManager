package com.example.util;

import java.io.IOException;
import com.example.dao.BoardDAO;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;
import com.example.bean.BoardVO;
import javax.servlet.http.HttpServletRequest;

public class FileUpload {
    public BoardVO uploadPhoto(final HttpServletRequest request) {
        String filename = "";

        final int sizeLimit = 15728640;
        final String realPath = request.getServletContext().getRealPath("upload");

        final File dir = new File(realPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        BoardVO detail = null;
        MultipartRequest multipartRequest = null;

        try {
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", (FileRenamePolicy)new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            detail = new BoardVO();

            final String seq = multipartRequest.getParameter("seq");
            if (seq != null && !seq.equals("")) {
                detail.setSeq(Integer.parseInt(seq));
            }
            detail.setName(multipartRequest.getParameter("name"));
            detail.setPhoneNum(multipartRequest.getParameter("phoneNum"));
            detail.setEmail(multipartRequest.getParameter("email"));
            detail.setBirthDate(multipartRequest.getParameter("birthDate"));
            if (seq != null && !seq.equals("")) {
                final BoardDAO dao = new BoardDAO();
                final String oldFilename = dao.getPhotoFilename(Integer.parseInt(seq));
                if (filename != null & oldFilename != null) {
                    deleteFile(request, oldFilename);
                }
                else if (filename == null && oldFilename != null) {
                    filename = oldFilename;
                }
            }
            detail.setPhoto(filename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return detail;
    }

    public static void deleteFile(final HttpServletRequest request, final String filename) {
        final String filePath = request.getServletContext().getRealPath("upload");
        final File f = new File(filePath + "/" + filename);
        if (f.exists()) {
            f.delete();
        }
    }
}
