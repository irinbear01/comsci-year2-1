import numpy as np
import matplotlib.pyplot as plt

# รับข้อมูลจากผู้ใช้
mobile_hours = list(map(float, input("กรอกชั่วโมงเล่นมือถือก่อนนอน (คั่นด้วยช่องว่าง): ").split()))
sleep_hours = list(map(float, input("กรอกชั่วโมงการนอนจริง (คั่นด้วยช่องว่าง): ").split()))

# สร้างสมการเชิงเส้น
coeff = np.polyfit(mobile_hours, sleep_hours, 1)
poly = np.poly1d(coeff)
estimate = poly(mobile_hours)

# แสดงสมการ
print("สมการเชิงเส้นที่ได้คือ:")
print(poly)

# วาดกราฟ
plt.scatter(mobile_hours, sleep_hours, color='blue', label='Actual data')
plt.plot(mobile_hours, estimate, color='red', label='Regression line')
plt.xlabel("Mobile phone use before sleep (hours)")
plt.ylabel("Actual sleep (hours)")
plt.title("Impact of mobile phone use before sleep on sleep duration")
plt.legend()
plt.grid()
plt.show()
