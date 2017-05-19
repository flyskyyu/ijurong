package com.party.ijurong;

/**
 * Created by Cloud on 2017/2/21.
 */
public class JsonTest {
    /*public static void main(String[] args) throws IOException {
        SysUser user = new SysUser();
        user.setUserName("cloud");
        user.setPassword("asdfsdf");
        user.setBirthday(new Date());
        user.setUserId(123123);
        Random random = new Random();
        ObjectMapper mapper = new ObjectMapper();
        String content;
        content = mapper.writeValueAsString(user);
        long current = System.currentTimeMillis();
        List users = new ArrayList();
        for(int i = 0; i < 1000;i ++) {
            SysUser user1 = new SysUser();
            user1.setUserName("cloud");
            user1.setPassword("asdfsdf");
            user1.setBirthday(new Date());
            user1.setUserId(random.nextInt());
            users.add(user1);
        }
        String val1 = mapper.writeValueAsString(users);
        System.out.println("json大小：" + val1.getBytes().length);
        byte[] buffer1 = SerializeUtils.serialize(users);
        System.out.println("java序列化大小：" + buffer1.length);
        for(int i = 0; i < 1; i++) {
            user.setUserId(random.nextInt());
            String val = mapper.writeValueAsString(user);
            System.out.println("json大小：" + val.getBytes().length);
        }
        for(int i = 0; i < 1; i++) {
            mapper.readValue(content, SysUser.class);
        }
        System.out.println("json序列化耗时：" + (System.currentTimeMillis() - current));
        byte[] bytes = null;
        current = System.currentTimeMillis();
        bytes = SerializeUtils.serialize(user);
        for(int i = 0; i < 1; i++) {
            user.setUserId(random.nextInt());
            byte[] buffer = SerializeUtils.serialize(user);
            System.out.println("java序列化大小：" + buffer.length);
        }
        for(int i = 0; i < 1; i++) {
            SerializeUtils.deserialize(bytes);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("java序列化耗时：" + (System.currentTimeMillis() - current));

    }*/
}
