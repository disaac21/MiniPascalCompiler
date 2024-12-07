; ModuleID = 'MiniPascal'
source_filename = "ManejoDeTipos"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-microsoft-msvc"
%struct._IO_FILE = type { i8*, i32, i32, i32, i8*, i8*, i8*, i8*, i8*, i32, i32, i32, i32, i8*, i8*, i8*, i32, i32, i32 }
@str_fmt = unnamed_addr constant [4 x i8] c"%d\0A\00"
@stdin = external global %struct._IO_FILE*
@double_fmt = private unnamed_addr constant [4 x i8] c"%f\0A\00"

define i32 @main() {
  ret i32 0
}

define void @write_int(i32 %num) {
  %buf = alloca [32 x i8], align 1
  %buf_ptr = getelementptr inbounds [32 x i8], [32 x i8]* %buf, i32 0, i32 0
  call i32 (i8*, i8*, ...) @printf(i8* %buf_ptr, i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)
  call i32 @puts(i8* %buf_ptr)
  ret void
}

define void @write_string(i8* %str) {
  %str_ptr = alloca i8*
  store i8* %str, i8** %str_ptr
  %str_val = load i8*, i8** %str_ptr
  call i32 @puts(i8* %str_val)
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