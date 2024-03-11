package frc.robot.commands;

import frc.robot.subsystems.Pickup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class PickupLength extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Pickup m_Pickup;
  private final double m_Length;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public PickupLength(double Length ,Pickup Pickup) {
    m_Length = Length;
    m_Pickup = Pickup;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Pickup);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  m_Pickup.Eat();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Pickup.Eat();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Pickup.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (true);
  }
}
