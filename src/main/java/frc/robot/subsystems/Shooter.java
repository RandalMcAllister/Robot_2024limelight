// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.PneumaticsConstants;
public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private WPI_VictorSPX shootSpeed = new WPI_VictorSPX(5);
  private DoubleSolenoid  beltSqushTop ;
  public Shooter() {
    beltSqushTop = new DoubleSolenoid(PneumaticsConstants.kModule1 , PneumaticsModuleType.CTREPCM, 2 , 3);
  }

   public void SqushTop(){
  beltSqushTop.set(Value.kForward);
  }
  public void deSqushTop(){
beltSqushTop.set(Value.kReverse);
  }
  public void shoot(){
    shootSpeed.set(0.5);
  }
  public void shootFast(){
    shootSpeed.set(1);
  }
  public void Stop(){
    shootSpeed.set(0);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command ex() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  

  
    // Query some boolean state, such as a digital sensor.
    
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
