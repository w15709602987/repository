package zuikecheng.utils;
import zuikecheng.bean.Customer;

import java.io.ByteArrayInputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
  * @author Administrator
  *
  */
 public class SerializeUtil {
    public static byte[] serialize(Object object) {
        /*
         * 序列化
         * */
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = null;
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return bytes;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if(baos != null){
                        baos.close();
                    }
                    if (oos != null) {
                        oos.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        /*
         * 反序列化
         * */
        public static Object unserialize(Set<byte[]> bytes){
            ByteArrayInputStream bais = null;
            ObjectInputStream ois = null;
            List list = new LinkedList();
            try {

                for (byte[] b : bytes) {
                    bais = new ByteArrayInputStream(b);
                    ois = new ObjectInputStream(bais);
                    list.add(ois.readObject());
                }
                ois.close();
                bais.close();
                return list;
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                try {

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
    }