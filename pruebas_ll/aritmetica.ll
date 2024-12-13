@.str = private constant [4 x i8] c"t13\00", align 1
@.str1 = private constant [4 x i8] c"t14\00", align 1
@.str2 = private constant [4 x i8] c"t15\00", align 1
@.str3 = private constant [16 x i8] c"Valor final: %d\00", align 1

declare i32 @printf(i8*, ...) #1

define void @main() {
entry:
    ; t13 = 3 + 5
    %t13 = add i32 3, 5

    ; t14 = 7 * 8
    %t14 = mul i32 7, 8

    ; t15 = t13 + t14
    %t15 = add i32 %t13, %t14

    ; x_val13 = t15
    store i32 %t15, i32* @x_val13

    ; Llamada a printf para imprimir el valor final
    %format_str = getelementptr [16 x i8], [16 x i8]* @.str3, i32 0, i32 0
    %val = load i32, i32* @x_val13
    call i32 (i8*, ...) @printf(i8* %format_str, i32 %val)

    ret void
}

@x_val13 = global i32 0, align 4
