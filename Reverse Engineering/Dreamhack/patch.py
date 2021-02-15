#Dreamhack patch problem
import sys
from PyQt5.QtWidgets import QWidget, QApplication
from PyQt5.QtGui import QPainter, QPen
from PyQt5.QtCore import Qt


class MyApp(QWidget):

    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        self.setGeometry(300, 300, 400, 300)
        self.setWindowTitle('drawLine')
        self.show()

    def paintEvent(self, e):
        qp = QPainter()
        qp.begin(self)
        self.draw_line(qp)
        qp.end()

    def draw_line(self, qp):
        qp.setPen(QPen(Qt.black, 5))
        qp.drawLine(40, 31, 40, 59)
        qp.drawLine(40, 31, 68, 59)
        qp.drawLine(68, 60, 40, 88)
        qp.drawLine(40, 60, 40, 90)
        
        qp.drawLine(80, 31, 80, 59)
        qp.drawLine(110, 30, 110, 59)
        qp.drawLine(110, 61, 110, 90)
        qp.drawLine(80, 60, 110, 60)
        qp.drawLine(80, 60, 80, 90)

   
        qp.drawLine(135, 30, 125, 35)
        qp.drawLine(125, 35, 125, 85)
        qp.drawLine(125, 60, 115, 60)
        qp.drawLine(135, 90, 125, 85)

        qp.drawLine(160, 31, 160, 60)
        qp.drawLine(160, 61, 160, 89)

        qp.drawLine(161, 90, 190, 90)
        
        qp.drawLine(190, 31, 190, 60)
        qp.drawLine(190, 61, 190, 90)

      
        qp.drawLine(200, 31, 200, 59)
        qp.drawLine(200, 29, 230, 29)
        qp.drawLine(230, 30, 230, 59)
        qp.drawLine(200, 60, 230, 60)
        qp.drawLine(200, 60, 230, 90)

 
        qp.drawLine(240, 31, 240, 59)
        qp.drawLine(240, 29, 270, 29)
        qp.drawLine(270, 30, 270, 59)
        qp.drawLine(240, 61, 240, 90)
        qp.drawLine(270, 61, 270, 90)
        qp.drawLine(240, 60, 270, 60)

        qp.drawLine(281, 30, 310, 30)
        qp.drawLine(295, 31, 295, 60)
        qp.drawLine(295, 61, 295, 89)

        qp.drawLine(321, 30, 350, 30)
        qp.drawLine(320, 31, 320, 60)
        qp.drawLine(320, 61, 320, 89)
        qp.drawLine(320, 90, 350, 90)

        qp.drawLine(360, 31, 360, 59)
        qp.drawLine(390, 30, 390, 59)
        qp.drawLine(390, 61, 390, 90)
        qp.drawLine(360, 60, 390, 60)
        qp.drawLine(360, 60, 360, 90)
        qp.drawLine(401, 30, 430, 30)
        qp.drawLine(400, 31, 400, 60)
        qp.drawLine(400, 61, 400, 89)
        qp.drawLine(401, 90, 430, 90)
        qp.drawLine(401, 60, 430, 60)
        qp.drawLine(440, 31, 440, 59)
        qp.drawLine(440, 31, 468, 59)
        qp.drawLine(468, 60, 440, 88)
        qp.drawLine(440, 60, 440, 90)
        qp.drawLine(490, 35, 480, 30)
        qp.drawLine(490, 35, 490, 85)
        qp.drawLine(490, 60, 500, 60)
        qp.drawLine(490, 85, 480, 90)


   



if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MyApp()
    sys.exit(app.exec_())
