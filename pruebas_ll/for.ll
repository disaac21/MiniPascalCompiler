; Declaración de la función main
define i32 @main() {
entry:
    ; Inicialización del índice del bucle: i = 0
    %i = alloca i32
    store i32 0, i32* %i
    br label %loop_condition

loop_condition: ; Bloque de la condición del bucle
    ; Cargar el valor actual de i
    %i_val = load i32, i32* %i
    ; Comparar i con 5 (límite superior)
    %cmp = icmp slt i32 %i_val, 5
    ; Saltar al cuerpo del bucle si i < 5, de lo contrario salir
    br i1 %cmp, label %loop_body, label %loop_end

loop_body: ; Bloque del cuerpo del bucle
    ; Imprimir el valor de i
    %msg_ptr = getelementptr inbounds [4 x i8], [4 x i8]* @msg, i32 0, i32 0
    call i32 (i8*, ...) @printf(i8* %msg_ptr, i32 %i_val)
    ; Incrementar i: i = i + 1
    %next_i = add i32 %i_val, 1
    store i32 %next_i, i32* %i
    ; Volver a la condición del bucle
    br label %loop_condition

loop_end: ; Bloque al final del bucle
    ; Finalizar el programa con éxito
    ret i32 0
}

; Declaración del string para imprimir (formato "%d\n")
@msg = private constant [4 x i8] c"%d\0A\00"

; Declaración de printf
declare i32 @printf(i8*, ...)
