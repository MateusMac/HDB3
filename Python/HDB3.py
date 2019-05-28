import numpy as np
import matplotlib.pyplot as plt

string = input("Digite a sequência: ")
string = str(string)

strOutput = []
strOutputLabel = []


def output():
    contador = 0
    pulsoAnterior = 0
    violacoes = 0
    pulsoViolacao = 0

    for bit in string:
        if bit == str(1):
            if pulsoAnterior == 1:
                strOutput.append(-1)
                strOutputLabel.append(-1)
                pulsoAnterior = -1
                pulsoViolacao = -1
                violacoes = violacoes + 1
            elif pulsoAnterior == -1:
                strOutput.append(1)
                strOutputLabel.append(1)
                pulsoAnterior = 1
            elif pulsoAnterior == 0:
                strOutput.append(bit)
                strOutputLabel.append(bit)
                pulsoAnterior = int(bit)
        elif bit == str(0):
            contador = contador + 1
            if contador == 4:
                strOutput.pop()
                strOutput.pop()
                strOutput.pop()
                strOutputLabel.pop()
                strOutputLabel.pop()
                strOutputLabel.pop()
                if violacoes % 2 == 0:
                    # B00V
                    pulsoViolacao = pulsoAnterior * -1
                    strOutput.extend([pulsoViolacao, 0, 0, pulsoViolacao])
                    strOutputLabel.extend(["B", 0, 0, "V"])
                    violacoes = violacoes + 1
                    pulsoAnterior = pulsoViolacao

                else:
                    # 000V
                    strOutputLabel.extend([0, 0, 0, "V"])
                    strOutput.extend([0, 0, 0, pulsoViolacao])
                    violacoes = violacoes + 1
                contador = 0
            else:
                strOutput.append(bit)
                strOutputLabel.append(bit)


output()

x = np.arange(1, len(strOutput) + 1, 1)

plt.step(x, strOutput)
plt.xlabel(strOutputLabel)
plt.xlim(0, len(strOutput))
plt.ylim(-1, 1)
plt.title('HDB3 Encoding')
plt.show()
