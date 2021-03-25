package N;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BlockDeviceImpl implements BlockDevice{

    static int blocks;
    static int blockSize;

    static Queue<Integer> emptyBlocks = new LinkedList<>();
    static Map<Integer, Boolean> blockMap = new HashMap<>();

    public BlockDeviceImpl(int bSize, int blocks){
        blockSize = bSize;
        this.blocks = blocks;

        for(int i=0;i<blocks;++i) {
            emptyBlocks.add(i);
            blockMap.put(i, true);
        }

    }

    @Override
    public void initBlocks() {
        for(int i=0;i<blocks;++i){
            for(int j=0;j<blockSize;++j)
                blockStore[i][j]=0;
        }
    }

    @Override
    public void initFilestore() {
        fileRefStore.clear();
    }

    @Override
    public void emptyBlocks() {
        System.out.println("no. of block empty " + emptyBlocks.size());
        for(int i=0;i<blocks;++i){
            if(blockMap.get(i))
                System.out.println("block " + i + "is empty");
            else
                System.out.println("block " + i + "is used");
        }
    }

    @Override
    public void updateFileStore(File f, String name, boolean action) {
        if(action){ //add
            fileRefStore.put(name, f);
        }else{ //delete
            fileRefStore.remove(name);
        }
    }

    @Override
    public void storeFileData(File f, String data) {
        int j=0;
        while(!emptyBlocks.isEmpty()){
            int bId = emptyBlocks.poll();
            int i=0;
            for(;i<blockSize&& j<data.length();j++, i++){
                blockStore[bId][i] = data.charAt(j);
            }
            f.metaData.blockIds.add(bId);
            if(j==data.length())
                break;
        }
    }

    @Override
    public char [] getBlockData(int bId) {
        char [] c = blockStore[bId];

        char [] ret = new char[blockSize];
        for(int i=0;i<blockSize;++i)
            ret[i]=c[i];

        return ret;
    }

    @Override
    public File getFileRef(String name) {
        if(!fileRefStore.containsKey(name))
            return null; //replace with exception.
        return fileRefStore.get(name);
    }
}
