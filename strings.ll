; Declaración de la función @puts
declare i32 @puts(i8*)

; Definición de la función que imprime un string
define void @print_string(i8* %str) {
entry:
    ; Llama a @puts para imprimir el string
    call i32 @puts(i8* %str)
    ret void
}

; Ejemplo de uso en una función main
define i32 @main() {
entry:
    ; Convierte el string constante en un puntero compatible (i8*)
    %my_str = bitcast [13 x i8]* @.my_string to i8*
    ; Llama a la función @print_string con el string como argumento
    call void @print_string(i8* %my_str)
    ret i32 0
}

; Declaración del string constante
@.my_string = private constant [13 x i8] c"Hello, LLVM!\00"
