import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.EOFException;
import java.util.Vector;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ExtractFiles {

    protected void extract(String path, String extractpath) {
        String szZipFilePath;
        String szExtractPath;
        int i;

        System.out.println(
                "Enter full path to Zip-file: ");
        szZipFilePath = new String(path);

        File f = new File(szZipFilePath);
        if(!f.exists())
        {
            System.out.println(
                    "\nNot found: " + szZipFilePath);
            System.exit(0);
        }

        if(f.isDirectory())
        {
            System.out.println(
                    "\nNot file: " + szZipFilePath);
            System.exit(0);
        }

        System.out.println(
                "Enter path to extract files: ");
        szExtractPath = new String(extractpath);

        File f1 = new File(szExtractPath);
        if(!f1.exists())
        {
            System.out.println(
                    "\nNot found: " + szExtractPath);
            System.exit(0);
        }

        if(!f1.isDirectory())
        {
            System.out.println(
                    "\nNot directory: " + szExtractPath);
            System.exit(0);
        }

        ZipFile zf;
        Vector zipEntries = new Vector();

        try
        {
            zf = new ZipFile(szZipFilePath);
            Enumeration en = zf.entries();

            while(en.hasMoreElements())
            {
                zipEntries.addElement(
                        (ZipEntry)en.nextElement());
            }

            for (i = 0; i < zipEntries.size(); i++)
            {
                ZipEntry ze =
                        (ZipEntry)zipEntries.elementAt(i);

                extractFromZip(szZipFilePath,
                        szExtractPath,
                        ze.getName(), zf, ze);
            }

            zf.close();
            System.out.println("Done!");
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    protected void extractFromZip(
            String szZipFilePath, String szExtractPath,
            String szName,
            ZipFile zf, ZipEntry ze) {
        if(ze.isDirectory())
            return;

        String szDstName = slash2sep(szName);

        String szEntryDir;

        if(szDstName.lastIndexOf(File.separator) != -1)
        {
            szEntryDir =
                    szDstName.substring(
                            0,
                            szDstName.lastIndexOf(File.separator));
        }
        else
            szEntryDir = "";

        System.out.print(szDstName);
        long nSize = ze.getSize();
        long nCompressedSize =
                ze.getCompressedSize();

        System.out.println(" " + nSize + " (" +
                nCompressedSize + ")");

        try
        {
            File newDir = new File(szExtractPath +
                    File.separator + szEntryDir);

            newDir.mkdirs();

            FileOutputStream fos =
                    new FileOutputStream(szExtractPath +
                            File.separator + szDstName);

            InputStream is = zf.getInputStream(ze);
            byte[] buf = new byte[1024];

            int nLength;

            while(true)
            {
                try
                {
                    nLength = is.read(buf);
                }
                catch (EOFException ex)
                {
                    break;
                }

                if(nLength < 0)
                    break;
                fos.write(buf, 0, nLength);
            }

            is.close();
            fos.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            System.exit(0);
        }
    }

    protected String slash2sep(String src)
    {
        int i;
        char[] chDst = new char[src.length()];
        String dst;

        for(i = 0; i < src.length(); i++)
        {
            if(src.charAt(i) == '/')
                chDst[i] = File.separatorChar;
            else
                chDst[i] = src.charAt(i);
        }
        dst = new String(chDst);
        return dst;
    }

    public String getKbdString()
    {
        byte bKbd[] = new byte[256];
        int iCnt = 0;
        String szStr = "";

        try
        {
            iCnt = System.in.read(bKbd);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

        szStr = new String(bKbd, 0, iCnt);
        szStr = szStr.trim();
        return szStr;
    }
}