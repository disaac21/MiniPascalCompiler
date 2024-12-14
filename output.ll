; ModuleID = 'MiniPascal'
source_filename = "InlineReadWrite"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-microsoft-msvc"
%struct._IO_FILE = type { i8*, i32, i32, i32, i8*, i8*, i8*, i8*, i8*, i32, i32, i32, i32, i8*, i8*, i8*, i32, i32, i32 }
@buffer = global [256 x i8] zeroinitializer
@str_fmt = unnamed_addr constant [4 x i8] c"%d\0A\00"
@stdin = external global %struct._IO_FILE*
@double_fmt = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@char_fmt = private unnamed_addr constant [4 x i8] c"%c\0A\00"
@.str6 = private constant [25 x i8] c"El nombre ingresado es: \00"
@.str5 = private constant [24 x i8] c"La letra ingresada es: \00"
@.str4 = private constant [26 x i8] c"El número ingresado es: \00"
@.str3 = private constant [20 x i8] c"Ingrese su nombre: \00"
@.str2 = private constant [20 x i8] c"Ingrese una letra: \00"
@.str1 = private constant [21 x i8] c"Ingrese un número: \00"
declare i32 @scanf(i8*, ...)
@int_format = private constant [3 x i8] c"%d\00"       ; Formato para enteros
@char_format = private constant [4 x i8] c" %c\00"      ; Formato para caracteres
@str_format = private constant [3 x i8] c"%s\00"       ; Formato para cadenas

define i32 @main() {
    %numero = alloca i32
    %letra = alloca i8
    %nombre = alloca i8*
    call void @write_string(i8* getelementptr inbounds ([21 x i8], [21 x i8]* @.str1, i32 0, i32 0))
    %int_ptr1 = bitcast i32* %numero to i8* ;
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr1)
    %numero_val1 = load i32, i32* %numero
    call void @write_string(i8* getelementptr inbounds ([20 x i8], [20 x i8]* @.str2, i32 0, i32 0))
    %char_ptr2 = bitcast i8* %letra to i8* ;
    call i32 (i8*, ...) @scanf(i8* bitcast ([4 x i8]* @char_format to i8*), i8* %char_ptr2)
    %letra_val2 = load i8, i8* %letra
    call void @write_string(i8* getelementptr inbounds ([20 x i8], [20 x i8]* @.str3, i32 0, i32 0))
    %str_ptr3 = getelementptr inbounds [256 x i8], [256 x i8]* @buffer, i32 0, i32 0
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @str_format to i8*), i8* %str_ptr3)
    store i8* %str_ptr3, i8** %nombre
    %nombre_val3 = load i8*, i8** %nombre
    call void @write_string(i8* getelementptr inbounds ([26 x i8], [26 x i8]* @.str4, i32 0, i32 0))
    call void @write_int(i32 %numero_val1)
    call void @write_string(i8* getelementptr inbounds ([24 x i8], [24 x i8]* @.str5, i32 0, i32 0))
    call void @write_char(i8 %letra_val2)
    call void @write_string(i8* getelementptr inbounds ([25 x i8], [25 x i8]* @.str6, i32 0, i32 0))
    call void @write_string(i8* %nombre_val3)
  ret i32 0
}

define void @write_int(i32 %num) {
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)
    ret void
}

define void @write_char(i8 %char) {
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @char_fmt, i32 0, i32 0), i8 %char)
    ret void
}
define void @write_string(i8* %str) {
    call i32 @puts(i8* %str)
    ret void
}

declare i32 @atoi(i8*)
declare i32 @sprintf(i8*, i8*, ...)
declare i32 @puts(i8*)
declare i8* @fgets(i8*, i32, %struct._IO_FILE*)
declare void @exit(i32)

; Function Attrs: noinline nounwind optnone uwtable
declare i32 @printf(i8*, ...) #0
attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
!llvm.module.flags = !{!0}

!llvm.ident = !{!1}
!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 10.0.0-4ubuntu1 "}

