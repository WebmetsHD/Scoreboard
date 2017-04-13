ScoreboardManager sbm = Bukkit.getScoreboardManager();
		sb = sbm.getNewScoreboard();
		Objective obj = sb.registerNewObjective("Objective", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§4Force§cOp");
		teams = new ArrayList<Team>();
		for (int i = 10; i >= 1; i--) {
			Team t = sb.registerNewTeam(ChatColor.values()[i] + "");
			t.addEntry(ChatColor.values()[i] + "");
			teams.add(t);
			obj.getScore(ChatColor.values()[i] + "").setScore(i);
		}
		new BukkitRunnable() {
			int timer = 0;

			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					timer++;
					if (players.contains(p.getUniqueId().toString())) {
						sb.getTeam(ChatColor.values()[10] + "").setPrefix("§4--------------");
						sb.getTeam(ChatColor.values()[10] + "").setSuffix("§4--------------");

						sb.getTeam(ChatColor.values()[9] + "").setPrefix("§A[§DOPstatus§A]");
						sb.getTeam(ChatColor.values()[9] + "").setSuffix("§D§L: " + p.isOp());

						sb.getTeam(ChatColor.values()[8] + "").setPrefix("§4--------------");
						sb.getTeam(ChatColor.values()[8] + "").setSuffix("§4--------------");

						sb.getTeam(ChatColor.values()[7] + "").setPrefix("§A[§DGamemode§A]");
						sb.getTeam(ChatColor.values()[7] + "")
								.setSuffix("§D§L: " + p.getGameMode().toString().toLowerCase());

						sb.getTeam(ChatColor.values()[6] + "").setPrefix("§4--------------");
						sb.getTeam(ChatColor.values()[6] + "").setSuffix("§4--------------");

						sb.getTeam(ChatColor.values()[5] + "").setPrefix("§A[§DUptime§A]");
						sb.getTeam(ChatColor.values()[5] + "").setSuffix("§D§L: " + timer / 20);

						sb.getTeam(ChatColor.values()[4] + "").setPrefix("§4--------------");
						sb.getTeam(ChatColor.values()[4] + "").setSuffix("§4--------------");

						sb.getTeam(ChatColor.values()[3] + "").setPrefix("§A[§DHealth§A]§d");
						sb.getTeam(ChatColor.values()[3] + "").setSuffix("§d§L: " + (int) p.getHealth() + "/§D§L20");

						sb.getTeam(ChatColor.values()[2] + "").setPrefix("§4--------------");
						sb.getTeam(ChatColor.values()[2] + "").setSuffix("§4--------------");
						
						if(!kickCount.containsKey(p)) {
							kickCount.put(p, 0);
						}
						
						sb.getTeam(ChatColor.values()[1] + "").setPrefix("§A[§dKekCount§A]");
						sb.getTeam(ChatColor.values()[1] + "").setSuffix("§d§L: " + kickCount.get(p));

					}
				}
			}
		}.runTaskTimer(main, 0, 1);
