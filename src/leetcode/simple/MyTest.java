package leetcode.simple;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class MyTest {

    public static void main(String[] args) throws Throwable {
//        new ClassWriter(1).visit(Opcodes.V1_8, );

        System.out.println(new InvokeExact().invokeExact());

    }


}

class InvokeExact {
    public Object invokeExact() throws Throwable {

        Class helloWordClass = generate();

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType type = MethodType.methodType(void.class, String[].class);
        MethodHandle mh = lookup.findStatic(helloWordClass, "main", type);

        return mh.invoke(null);
    }

    public Class generate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassWriter cw = new ClassWriter(0);
        // 定义对象头：版本号、修饰符、全类名、签名、父类、实现的接口
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "sample/HelloWorld",
                null, "java/lang/Object", null);

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC,
                "<init>",
                "()V",
                null, null);
        //生成构造函数字节码指令 -- 加载操作
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL,
                "java/lang/Object",
                "<init>",
                "()V",
                false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        //TODO 2.构造main函数
        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC,
                "main",
                "([Ljava/lang/String;)V",
                null,
                null);

        //TODO 3.main方法中生成 System.out.println("Hello ASM");
        //获取System类中的属性  System.out --    public static final PrintStream out;
        mv.visitFieldInsn(GETSTATIC,
                "java/lang/System",
                "out",
                "Ljava/io/PrintStream;");

        //栈帧中 属性入栈
        mv.visitLdcInsn("Hello ASM 123");
        //加载 println 方法
        mv.visitMethodInsn(INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V",
                false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 2);
        mv.visitEnd();

        byte[] code = cw.toByteArray();// 生成字节数组

        //NOTE: 使用系统类加载器加载才能后续使用。
        Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
        defineClass.setAccessible(true);
        return (Class)defineClass.invoke(ClassLoader.getSystemClassLoader(), "sample.HelloWorld", code, 0, code.length);

    }
}