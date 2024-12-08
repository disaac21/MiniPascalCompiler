@str_format = private constant [3 x i8] c"%s\00"       ; Formato para cadenas
@buffer = private global [256 x i8] zeroinitializer    ; Buffer para almacenar cadenas
@char_format = private constant [3 x i8] c"%c\00"      ; Formato para caracteres
@int_format = private constant [3 x i8] c"%d\00"       ; Formato para enteros

declare i32 @scanf(i8*, ...)

define i32 @main() {
    %numero = alloca i32
    %letra = alloca i8
    %nombre = alloca i8*
%int_ptr1 = bitcast i32* %int_var to i8* ;
call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr1)
    ret i32 0
}
