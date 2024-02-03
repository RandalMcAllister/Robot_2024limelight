// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class MotorConstants {
    // climbing motor channels.
    public static final int kLClm1 = 1;
    public static final int kLClm2 = 2;
    public static final int kRClm1 = 3;
    public static final int kRClm2 = 4;
    // shoot channel
    public static final int kSho = 5;
    // pick up channel
    public static final int kPik = 6;
  }
  public static class PneumaticsConstants{
    public static final int kModule1 = 1;
    public static final int kModule2 = 2;
  }
  public static class DriveTrainConstants{
    public static final int kDriv1 = 7;
    public static final int kDriv2 = 8;
    public static final int kDriv3 = 9;
    public static final int kDriv4 = 10;
    public static final int kDriv5 = 11;
    public static final int kDriv6 = 12;
    public static final int kDriv7 = 13;
    public static final int kDriv8 = 14;
  }
}
