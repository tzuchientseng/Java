import numpy as np
# from scipy import stats

from statistic import * 

print("-----------------Descriptive Statistics (Estimate \u03BC)-----------------")
data = [148, 155, 126, 117, 124, 136, 141, 133, 129, 129, 146]
object = DesData(data)
object2 = DesData() #No Detail of Data
print(f"The data:{data}")
print("Average:", object.mean())
print("Variance:", object.vari())
print("Standard Deviation:", object.dev())
print("Median:", object.median())
print("Mode:", object.mode())
print("Variance (ddof=1):", object.samp_vari())
print("Standard Deviation (ddof=1):", object.samp_dev())

confidence_level = 90
lower, upper = object.bound(90)
print(f"The mean (\u03BC) estimate (\u03C3 unknown): [{lower:.2f}, {upper:.2f}]")
lower, upper = object.bound(90, sigma=11.28)
print(f"The mean (\u03BC) estimate (\u03C3 known): [{lower:.2f}, {upper:.2f}]")
lower, upper = object2.bound(90, sigma=11.28, mean=100, sample=15)
print(f"The mean (\u03BC) estimate (sigma=11.28, mean=100, sample=15): [{lower:.2f}, {upper:.2f}]")

print("\n-----------------Descriptive Statistics (Estimate p)-----------------")
successes = 6
trials = 150
confidence_level_p = 99  
lower, upper = object2.p_ci(confidence_level_p, successes, trials)
print(f"{confidence_level_p:.1f}% confidence interval for Bernoulli parameter p: [{lower:.3f}, {upper:.3f}]")

print("\n-----------------Descriptive statistics (Estimate sigma)-----------------")
confidence_level_sigma = 98
ci = object.var_ci(confidence_level_sigma)
print(f"{confidence_level_sigma:.1f}% Confidence Interval for Variance: [{ci[0]:.2f}, {ci[1]:.2f}]")
