package com.serveeasy.utils.file;

import java.io.*;

/**
 * User: cristian.popovici
 */
public final class FileUtils {

    private final InputStream in;

    private FileUtils(InputStream in) {
        this.in = in;
    }

    public static FileUtils open(File f) {
        if (f == null) {
            throw new NullPointerException("File is null");
        }

        if (!f.isFile()) {
            throw new IllegalArgumentException("Not a file");
        }

        try {
            return new FileUtils(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not locate file", e);
        }
    }

    public static FileUtils open(InputStream in) {
        if (in == null) {
            throw new NullPointerException("Null input stream object");
        }

        return new FileUtils(in);
    }

    public void readLine(Line reader) {
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                reader.value(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not localte file", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException encountered", e);
        } finally {
            closeStream();
        }
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Streams.copy(in, out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("could not perform copy operation", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }


    private void closeStream() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                // --
            }
        }
    }
}
