SSTACK SEGMENT STACK
       DW 64 DUP(?)
SSTACK ENDS
DATA SEGMENT
    WORDS DB 0DH,0AH,"Hello! My university!$"
DATA ENDS
CODE SEGMENT
    ASSUME CS:CODE,SS:SSTACK,DS:DATA
START:  MOV CX,001AH
        MOV DL,61H  ;将小写英文字母a的值存储到DL中
        MOV AL,DL
A1:     MOV AH,02H  ;循环打印小写英文字母
        INT 21H
        INC DL
        PUSH CX
        MOV CX,0FFFFH
A2:     LOOP A2 ;循环执行标签A2处指令知道CX为0
        POP CX  ;从堆栈中弹出一个值到寄存器CX中
        DEC CX
        JNZ A1      ;如果CX寄存器的值不为0,则跳转到A1标签处继续执行
        MOV AX,DATA ;将数据段定义的字符串移动到AX寄存器中
        MOV DS,AX   
        MOV AH,09H  ;使用09H打印字符串
        LEA DX,WORDS
        INT 21H
        MOV AX,4C00H
        INT 21H
CODE ENDS
    END START

