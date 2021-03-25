package N;

import java.util.HashMap;
import java.util.Map;

public interface BlockDevice {
    Map<String, File> fileRefStore = new HashMap<>();
    char [][] blockStore = new char[100][100];

    void initBlocks();
    void initFilestore();

    void emptyBlocks();

    void updateFileStore(File f, String name, boolean action);

    void storeFileData(File f, String data);
    char [] getBlockData(int bId);

    File getFileRef(String name);
}
