package N;

public class FileHandler {

    BlockDeviceImpl blockHandler;

    public FileHandler(BlockDeviceImpl blockHandler){
        this.blockHandler = blockHandler;
    }

    public File fClose(File f){
        return null;
    }

    public File fOpen(String name) throws Exception{
        File r;
        try{
            r = blockHandler.getFileRef(name); // or exception
        }catch (Exception e){
            System.out.println(name + " : file not found");
            throw  e;
        }
        return r;
    }

    public void fWrite(String name, String data){
        File f = new File(name, data);
        blockHandler.storeFileData(f, data);
        blockHandler.updateFileStore(f, name, true);
    }

    public String fRead(File f) throws Exception{
        validations(f);
        StringBuilder ret = new StringBuilder();

        for(int i : f.metaData.blockIds){
            String s = new String(blockHandler.getBlockData(i));
            System.out.println(s);
            ret.append(s);
        }
        return ret.toString();
    }

    private void validations(File f) throws Exception {
        if(f==null){
            throw new Exception("invalid file reference");
        }
    }

}
