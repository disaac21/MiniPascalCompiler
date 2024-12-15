; ModuleID = 'MiniPascal'
source_filename = "FuncionesParametrosPorValorYReferencia"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-microsoft-msvc"
%struct._IO_FILE = type { i8*, i32, i32, i32, i8*, i8*, i8*, i8*, i8*, i32, i32, i32, i32, i8*, i8*, i8*, i32, i32, i32 }
@buffer = global [256 x i8] zeroinitializer
@str_fmt = unnamed_addr constant [4 x i8] c"%d\0A\00"
@stdin = external global %struct._IO_FILE*
@double_fmt = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@char_fmt = private unnamed_addr constant [4 x i8] c"%c\0A\00"
@.str8 = private constant [40 x i8] c"Valor de suma después de la función: \00"
@.str7 = private constant [17 x i8] c"Suma calculada: \00"
@.str6 = private constant [39 x i8] c"Llamando a la función SumarValores...\00"
@.str5 = private constant [31 x i8] c"Valor inicial de cadenaFinal: \00"
@.str4 = private constant [20 x i8] c"Valor de caracter: \00"
@.str3 = private constant [19 x i8] c"Valor de numero2: \00"
@.str2 = private constant [19 x i8] c"Valor de numero1: \00"
@.str1 = private constant [12 x i8] c"resultado: \00"
define i32 @SumarValores(i32 %cont_resultado) {
entry:
    %SumarValores = alloca i32
    %resultado = alloca i32
    store i32 %cont_resultado, i32* %resultado
    %resultado_val22 = load i32, i32* %resultado

    call void @write_string(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @.str1, i32 0, i32 0))
    call void @write_int(i32 %resultado_val22)
%t23 = add i32 3, %resultado_val22
store i32 %t23, i32* %SumarValores
%SumarValores_val24 = load i32, i32* %SumarValores
    ret i32 %SumarValores_val24
}


define i32 @main() {
    %numero1 = alloca i32
    %numero2 = alloca i32
    %suma = alloca i32
    %cadenaFinal = alloca i8*
    %caracter = alloca i8
    store i32 5, i32* %numero1
    %numero1_val25 = load i32, i32* %numero1
    store i32 10, i32* %numero2
    %numero2_val26 = load i32, i32* %numero2
    store i8 65, i8* %caracter
    %caracter_val27 = load i8, i8* %caracter
    store i32 0, i32* %suma
    %suma_val28 = load i32, i32* %suma
    call void @write_string(i8* getelementptr inbounds ([19 x i8], [19 x i8]* @.str2, i32 0, i32 0))
    call void @write_int(i32 %numero1_val25)
    call void @write_string(i8* getelementptr inbounds ([19 x i8], [19 x i8]* @.str3, i32 0, i32 0))
    call void @write_int(i32 %numero2_val26)
    call void @write_string(i8* getelementptr inbounds ([20 x i8], [20 x i8]* @.str4, i32 0, i32 0))
    call void @write_char(i8 %caracter_val27)
    call void @write_string(i8* getelementptr inbounds ([31 x i8], [31 x i8]* @.str5, i32 0, i32 0))
    call void @write_string(i8* getelementptr inbounds ([39 x i8], [39 x i8]* @.str6, i32 0, i32 0))
    call void @write_string(i8* getelementptr inbounds ([17 x i8], [17 x i8]* @.str7, i32 0, i32 0))
    call void @write_int(i32 %suma_val28)
    %suma_val29 = call i32 @SumarValores(i32 5)
    call void @write_string(i8* getelementptr inbounds ([40 x i8], [40 x i8]* @.str8, i32 0, i32 0))
    call void @write_int(i32 %suma_val29)
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

