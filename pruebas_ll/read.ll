; Archivo: input_example.ll

@.str = private unnamed_addr constant [3 x i8] c"%d\00", align 1 ; Formato para scanf (leer un entero)
@.output_str = private unnamed_addr constant [27 x i8] c"El valor ingresado es: %d\0A\00", align 1 ; Formato para printf (salida)

declare i32 @scanf(i8*, ...) ; Declaración de scanf
declare i32 @printf(i8*, ...) ; Declaración de printf

define i32 @main() {
entry:
    ; Reservar espacio para la variable en la pila
    %input = alloca i32, align 4

    ; Leer el valor ingresado por el usuario
    %str_ptr = getelementptr inbounds [4 x i8], [4 x i8]* @.str, i32 0, i32 0
    call i32 (i8*, ...) @scanf(i8* %str_ptr, i32* %input)

    ; Leer el valor almacenado en la variable
    %input_val = load i32, i32* %input, align 4

    ; Imprimir el valor ingresado
    %output_str_ptr = getelementptr inbounds [21 x i8], [21 x i8]* @.output_str, i32 0, i32 0
    call i32 (i8*, ...) @printf(i8* %output_str_ptr, i32 %input_val)

    ; Retornar 0
    ret i32 0
}
