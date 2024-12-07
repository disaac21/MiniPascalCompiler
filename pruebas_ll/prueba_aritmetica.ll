; Archivo: ejemplo.ll
; Este archivo representa un programa en LLVM IR que realiza una operación aritmética:
; result = (a + b) * c

; Declaramos la función principal
define i32 @main() {
; entry:
  ; Declaramos las variables a, b y c
  %a = alloca i32              ; Reservar espacio para la variable a
  %b = alloca i32              ; Reservar espacio para la variable b
  %c = alloca i32              ; Reservar espacio para la variable c
  %result = alloca i32         ; Reservar espacio para almacenar el resultado

  ; Asignamos valores a las variables
  store i32 5, i32* %a         ; a = 5
  store i32 10, i32* %b        ; b = 10
  store i32 2, i32* %c         ; c = 2

  ; Cargamos los valores de las variables
  %a_val = load i32, i32* %a   ; Cargar el valor de a
  %b_val = load i32, i32* %b   ; Cargar el valor de b
  %c_val = load i32, i32* %c   ; Cargar el valor de c

  ; Realizamos la suma a + b
  %sum = add i32 %a_val, %b_val

  ; Multiplicamos el resultado por c
  %mul = mul i32 %sum, %c_val

  ; Guardamos el resultado final
  store i32 %mul, i32* %result

  ; Retornamos el resultado
  %result_val = load i32, i32* %result
  ret i32 %result_val
}
