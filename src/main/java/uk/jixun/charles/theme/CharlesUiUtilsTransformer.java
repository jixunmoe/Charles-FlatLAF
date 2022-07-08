package uk.jixun.charles.theme;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

class CharlesUiUtilsTransformer extends ClassVisitor {
    public CharlesUiUtilsTransformer(ClassVisitor classVisitor) {
        super(Opcodes.ASM6, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if ("g".equals(name) && "()V".equals(descriptor)) {
            System.out.println("Found: com.xk72.charles.gui.lib.UIUtils::g()V");
            return new AdviceAdapter(Opcodes.ASM6, mv, access, name, descriptor) {
                @Override
                protected void onMethodEnter() {
                    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                    mv.visitLdcInsn(">>> Hooked - not resetting LAF to system default.");
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

                    mv.visitInsn(Opcodes.RETURN);
                }
            };
        }

        return mv;
    }
}
